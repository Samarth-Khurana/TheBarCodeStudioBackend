package com.thebarcodestuido.backend.repositories

import com.thebarcodestuido.backend.domain.entities.ImageEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ImageRepository : JpaRepository<ImageEntity, Long>