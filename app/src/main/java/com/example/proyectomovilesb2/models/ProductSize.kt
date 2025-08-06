package com.example.proyectomovilesb2.models

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity(tableName = "productSizes", primaryKeys = ["productId", "size"])
@Serializable
data class ProductSize(
    val productId: Int,
    val size: Int,
)