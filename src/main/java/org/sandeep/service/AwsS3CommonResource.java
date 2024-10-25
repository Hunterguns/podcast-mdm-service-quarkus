package org.sandeep.service;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.sandeep.model.FormData;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;

abstract public class AwsS3CommonResource {

    protected PutObjectRequest buildPutObjectRequest(FormData formData, String bucketName){
        return PutObjectRequest.builder()
                .bucket(bucketName)
                .key(formData.fileName)
                .contentType(formData.mimeType)
                .build();
    }

    protected GetObjectRequest buildGetObjectRequest(String objectKey, String bucketName){
        return GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();
    }

    protected ListObjectsRequest buildListObjectsRequest(String bucketName){
        return ListObjectsRequest.builder().bucket(bucketName).build();
    }
}
