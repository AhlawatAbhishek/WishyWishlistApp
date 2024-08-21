package com.mayurappstudios.wishywishlistapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayurappstudios.wishywishlistapp.model.data.Wish
import com.mayurappstudios.wishywishlistapp.model.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val _wishRepository: WishRepository = Graph.wishRepository) : ViewModel() {
    private var _wishTitleState = mutableStateOf("");
    private var _wishDescriptionState = mutableStateOf("");
    val wishTitleState: State<String> = _wishTitleState;
    val wishDescriptionState: State<String> = _wishDescriptionState;
    fun onWishTitleChanged(wishTitle: String) {
        _wishTitleState.value = wishTitle;
    }
    fun onWishDescriptionChanged(wishDescription: String) {
        _wishDescriptionState.value = wishDescription;
    }
    var myInt : Int = 0
    lateinit var getAllWishes : Flow<List<Wish>>;
    init {
        viewModelScope.launch{
            getAllWishes = _wishRepository.getWishes()
        }
    }
    fun addWIsh(wish : Wish){
        viewModelScope.launch(Dispatchers.IO){
            _wishRepository.addWish(wish)
        }
    }

    fun updateWIsh(wish : Wish){
        viewModelScope.launch(Dispatchers.IO){
            _wishRepository.updateWish(wish)
        }
    }
    fun getAWishById(id: Int): Flow<Wish> {
        return _wishRepository.getAWishById(id)
    }

    fun deleteWish(wish : Wish){
        viewModelScope.launch(Dispatchers.IO){
            _wishRepository.deleteWish(wish = wish)
        }
    }
}