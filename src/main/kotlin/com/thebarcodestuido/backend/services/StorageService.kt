package com.thebarcodestuido.backend.services

import org.springframework.web.multipart.MultipartFile

interface StorageService {
    fun uploadFile(file: MultipartFile): String
}