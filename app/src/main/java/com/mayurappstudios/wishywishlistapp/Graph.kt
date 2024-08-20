package com.mayurappstudios.wishywishlistapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.mayurappstudios.wishywishlistapp.model.data.WishDatabase
import com.mayurappstudios.wishywishlistapp.model.data.WishRepository

object Graph {
    lateinit var wishDatabase: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = wishDatabase.wishDao())
    }

    fun provide(context : Context){
        wishDatabase = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}