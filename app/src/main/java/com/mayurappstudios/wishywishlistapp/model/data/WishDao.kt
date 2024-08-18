package com.mayurappstudios.wishywishlistapp.model.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addWish(wishEntity: Wish)

    //Load all the wishes from wish_table
    @Query("Select * from `wish_table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query("Select * from `wish_table` where id = :id")
    abstract fun getWishById(id: Int): Flow<Wish>

}