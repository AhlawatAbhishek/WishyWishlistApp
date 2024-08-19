package com.mayurappstudios.wishywishlistapp

import androidx.room.Database
import com.mayurappstudios.wishywishlistapp.model.data.WishDatabase
import com.mayurappstudios.wishywishlistapp.model.data.WishRepository

object Graph {
    lateinit var wishDatabase: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = wishDatabase.wishDao())
    }
}