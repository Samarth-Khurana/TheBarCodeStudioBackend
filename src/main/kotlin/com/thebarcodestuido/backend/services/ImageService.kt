package com.thebarcodestuido.backend.services

import com.thebarcodestuido.backend.domain.entities.ImageEntity

interface ImageService {
    fun getAllImages(): List<ImageEntity>
    fun save(newImage: ImageEntity): ImageEntity
}