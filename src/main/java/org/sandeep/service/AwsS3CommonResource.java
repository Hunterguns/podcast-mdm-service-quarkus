package org.sandeep.service;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.sandeep.model.FormData;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

abstract public class AwsS3CommonResource {

    @ConfigProperty(name = "bucket.name")
    private String bucketName;

    protected PutObjectRequest buildPutObjectRequest(FormData formData){
        return PutObjectRequest.builder()
                .bucket(bucketName)
                .key(formData.fileName)
                .contentType(formData.mimeType)
                .build();
    }

    protected GetObjectRequest buildGetObjectRequest(String objectKey){
        return GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();
    }
}
