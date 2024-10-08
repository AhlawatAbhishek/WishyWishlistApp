package com.mayurappstudios.wishywishlistapp.model.RepositoryAndDB

import com.mayurappstudios.wishywishlistapp.model.data.Wish
import com.mayurappstudios.wishywishlistapp.model.data.WishDao
import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao : WishDao) {
    suspend fun  addWish(wish : Wish){
          wishDao.addWish(wish)
     }
    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()
    fun getAWishById(id: Int): Flow<Wish> = wishDao.getWishById(id)
    suspend fun updateWish(wish: Wish){
        wishDao.updateWish(wish)
    }
    suspend fun deleteWish(wish: Wish){
        wishDao.deleteWish(wish)
    }
}