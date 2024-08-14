package com.mayurappstudios.wishywishlistapp.model.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = "",
    val isWishListed: Boolean = false
)

object DummyWish {
    val wishList = listOf(
        Wish(
            id = 1L,
            title = "OnePlus 9 Pro",
            description = "OnePlus 9 Pro is a flagship smartphone from OnePlus.",
            isWishListed = false
        ),
        Wish(
            id = 2L,
            title = "MacBook Pro",
            description = "MacBook Pro is a laptop from Apple.",
            isWishListed = false
        ),
        Wish(
            id = 3L,
            title = "Samsung Galaxy S21 Ultra",
            description = "Samsung Galaxy S21 Ultra is a flagship smartphone from Samsung.",
            isWishListed = false
        ),
        Wish(
            id = 4L,
            title = "Google Pixel 5",
            description = "Google Pixel 5 is a flagship smartphone from Google.",
            isWishListed = false
        ),
    )
}