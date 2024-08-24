package com.mayurappstudios.wishywishlistapp.model.RepositoryAndDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mayurappstudios.wishywishlistapp.model.data.Wish
import com.mayurappstudios.wishywishlistapp.model.data.WishDao

@Database(entities = [Wish::class], version = 1, exportSchema = false)
abstract class WishDatabase : RoomDatabase() {
    abstract fun wishDao() : WishDao
}