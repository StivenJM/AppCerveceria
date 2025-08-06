package com.example.proyectomovilesb2.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PaymentProvider(
    @PrimaryKey val id: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
) {
    companion object {
        val empty = PaymentProvider(
            id = "",
            title = -1,
            icon = -1
        )
    }
}
