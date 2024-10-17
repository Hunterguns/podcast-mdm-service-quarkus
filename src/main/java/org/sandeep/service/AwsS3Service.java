package org.sandeep.service;

import com.google.common.base.Strings;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.sandeep.model.FormData;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Slf4j
public class AwsS3Service extends AwsS3CommonResource{

    @ConfigProperty(name = "bucket.name")
    private String bucketName;

    @Inject
    S3Client s3Client;

    @POST
    @Path("/upload-file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(FormData formData){
        if(Strings.isNullOrEmpty(formData.getFileName()) || Strings.isNullOrEmpty(formData.getMimeType())){
            log.error("File Name or mimetype is missing while uploading file.");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        PutObjectResponse putObjectResponse = s3Client.putObject(buildPutObjectRequest(formData, bucketName), RequestBody.fromFile(formData.getFile()));
        if(putObjectResponse!=null){
            return Response.ok().status(Response.Status.CREATED).build();
        }else{
            return Response.serverError().build();
        }
    }

//    @GET
//    @Path("/download-file")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    public Response downloadFile(String objectKey){
//        if(Strings.isNullOrEmpty(objectKey)){
//            log.error("Object Key missing while downloading file");
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//        ResponseBytes<GetObjectResponse> objectAsBytes = s3Client.getObjectAsBytes(buildGetObjectRequest(objectKey, bucketName));
//
//    }
}
