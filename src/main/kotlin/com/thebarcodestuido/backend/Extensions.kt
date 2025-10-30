package com.thebarcodestuido.backend

import com.thebarcodestuido.backend.domain.dtos.ImageDto
import com.thebarcodestuido.backend.domain.entities.ImageEntity

fun ImageEntity.toImageDto(): ImageDto {
    return ImageDto(
        id = this.id,
        url = this.url
    )
}

fun ImageDto.toImageEntity(): ImageEntity {
    return ImageEntity(
        id = this.id,
        url = this.url
    )
}
