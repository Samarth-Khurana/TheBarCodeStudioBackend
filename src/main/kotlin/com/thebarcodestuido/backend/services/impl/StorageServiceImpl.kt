package com.thebarcodestuido.backend.services.impl

import com.thebarcodestuido.backend.services.StorageService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import java.io.IOException

@Service
class StorageServiceImpl(
    private val s3Client: S3Client,
    @Value("\${aws.s3.bucket-name}") private val bucketName: String
) : StorageService{
    private val r2PublicUrl = "https://pub-0c02a4d7bce646c5947083dcea607ecd.r2.dev"
    override fun uploadFile(file: MultipartFile): String {
        return try {
            val uniqueFileName = "${System.currentTimeMillis()}_${file.originalFilename}"

            val putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(uniqueFileName)
                .contentType(file.contentType)
                .build()

            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.bytes))

            "$r2PublicUrl/$uniqueFileName"
        } catch (e: IOException) {
            throw RuntimeException("Failed to upload file", e)
        }
    }
}