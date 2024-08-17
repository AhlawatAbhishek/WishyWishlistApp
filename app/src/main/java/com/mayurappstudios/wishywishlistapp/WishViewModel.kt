package com.mayurappstudios.wishywishlistapp

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel : ViewModel() {
    private var _wishTitleState = mutableStateOf("");
    private var _wishDescriptionState = mutableStateOf("");
    val wishTitleState: State<String> = _wishTitleState;
    val wishDescriptionState: State<String> = _wishDescriptionState;
    fun onWishTitleChanged(wishTitle: String) {
        _wishTitleState.value = wishTitle;
    }
    fun onWishDescriptionState(wishDescription: String) {
        _wishDescriptionState.value = wishDescription;
    }
}