package com.mayurappstudios.wishywishlistapp.model.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = "",
    val isWishListed: Boolean = false
)