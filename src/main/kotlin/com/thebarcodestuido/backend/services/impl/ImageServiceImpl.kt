package com.thebarcodestuido.backend.services.impl

import com.thebarcodestuido.backend.domain.entities.ImageEntity
import com.thebarcodestuido.backend.repositories.ImageRepository
import com.thebarcodestuido.backend.services.ImageService
import org.springframework.stereotype.Service

@Service
class ImageServiceImpl(
    private val imageRepository: ImageRepository
) : ImageService{
    override fun getAllImages(): List<ImageEntity> {
        return imageRepository.findAll()
    }

    override fun save(newImage: ImageEntity): ImageEntity {
        val imageEntity = imageRepository.save(newImage)
        return imageEntity
    }
}