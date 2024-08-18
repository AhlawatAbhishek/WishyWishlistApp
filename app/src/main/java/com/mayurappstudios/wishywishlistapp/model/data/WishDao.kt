package com.mayurappstudios.wishywishlistapp.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun addWish(wishEntity: Wish)

    @Query("Select * from `wish_table`")
    abstract fun getAllWishes(): Flow<List<Wish>>
}