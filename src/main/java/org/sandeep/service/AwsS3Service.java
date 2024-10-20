package org.sandeep.service;

import com.google.common.base.Strings;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.sandeep.model.FormData;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.File;
import java.net.URI;
import java.time.Duration;
import java.util.List;

@Slf4j
@Path("/s3")
public class AwsS3Service extends AwsS3CommonResource {

    //    @ConfigProperty(name = "s3.bucket.name")
    private String bucketName = "podcast-audio-bucket";


    S3Client s3Client = S3Client.builder()
            .httpClient(ApacheHttpClient.builder().maxConnections(10).connectionTimeout(Duration.ofSeconds(5)).socketTimeout(Duration.ofSeconds(30)).build())
            .region(Region.US_EAST_1)
            .endpointOverride(URI.create("http://localhost:4566"))
            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("awslocal", "awslocal")))
            .forcePathStyle(true)
            .overrideConfiguration(ClientOverrideConfiguration.builder().apiCallTimeout(Duration.ofMinutes(5)).apiCallAttemptTimeout(Duration.ofMinutes(2)).build())
            .build();

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(FormData formData) {
        if (Strings.isNullOrEmpty(formData.getFileName()) || Strings.isNullOrEmpty(formData.getMimeType())) {
            log.error("File Name or mimetype is missing while uploading file.");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        File file = formData.getFile();
        if (file != null) {
            log.info("Attempting to upload file: " + file.getAbsolutePath());
            log.info("File size: " + file.length() + " bytes");
            log.info("File readable: " + file.canRead());
        } else {
            log.error("File object is null");
        }
        PutObjectResponse putObjectResponse = s3Client.putObject(buildPutObjectRequest(formData, bucketName), RequestBody.fromFile(formData.getFile()));
        if (putObjectResponse != null) {
            return Response.ok().status(Response.Status.CREATED).build();
        } else {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/download-file")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(String objectKey) {
        if (Strings.isNullOrEmpty(objectKey)) {
            log.error("Object Key missing while downloading file");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        ResponseBytes<GetObjectResponse> objectAsBytes = s3Client.getObjectAsBytes(buildGetObjectRequest(objectKey, bucketName));
        Response.ResponseBuilder response = Response.ok(objectAsBytes.asByteArray());
        response.header("Content-Disposition", "attachment;filename=" + objectKey);
        response.header("Content-Type", objectAsBytes.response().contentType());
        return response.build();
    }

    @GET
    @Path("/list-objects")
    public List<String> listObjects() {
        ListObjectsResponse listObjectsResponse = s3Client.listObjects(buildListObjectsRequest(bucketName));
        return listObjectsResponse.contents().stream().map(t -> t.key()).toList();
    }


}
