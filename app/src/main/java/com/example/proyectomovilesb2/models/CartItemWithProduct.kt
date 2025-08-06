package com.example.proyectomovilesb2.models

import androidx.room.Embedded
import androidx.room.Relation

data class CartItemWithProduct(
    @Embedded
    val details: CartItem,
    @Relation(parentColumn = "productId", entityColumn = "id", entity = Product::class)
    val product: LocalProduct,
)
