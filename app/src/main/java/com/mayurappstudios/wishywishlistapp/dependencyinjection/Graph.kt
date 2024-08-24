package com.mayurappstudios.wishywishlistapp.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.mayurappstudios.wishywishlistapp.model.RepositoryAndDB.WishDatabase
import com.mayurappstudios.wishywishlistapp.model.RepositoryAndDB.WishRepository

object Graph {
    lateinit var wishDatabase: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = wishDatabase.wishDao())
    }

    fun provide(context : Context){
        wishDatabase = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}