package com.thebarcodestuido.backend.controllers

import com.thebarcodestuido.backend.domain.dtos.ImageDto
import com.thebarcodestuido.backend.domain.entities.ImageEntity
import com.thebarcodestuido.backend.services.ImageService
import com.thebarcodestuido.backend.services.StorageService
import com.thebarcodestuido.backend.toImageDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api/images")
@CrossOrigin(origins = ["http://localhost:3000", "https:/thebarcodestudio.vercel.app"])
class ImageController(
    private val storageService: StorageService,
    private val imageService: ImageService
) {

    @GetMapping
    fun getAllImages(): List<ImageDto> {
        return imageService.getAllImages().map {
            it.toImageDto()
        }
    }

    @PostMapping("/upload")
    fun uploadImage(
        @RequestParam("file") file: MultipartFile,
    ): ResponseEntity<ImageDto> {

        val url = storageService.uploadFile(file)

        val newImage = ImageEntity().apply { this.url = url }
        val savedImage = imageService.save(newImage)

        return ResponseEntity.ok(savedImage.toImageDto())
    }
}

