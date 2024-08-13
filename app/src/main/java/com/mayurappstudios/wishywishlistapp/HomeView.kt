package com.mayurappstudios.wishywishlistapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeView(modifier: Modifier = Modifier){
    Scaffold(modifier = modifier, topBar = {AppBarView(title = "Wishy Wishlist")}) {
         innerPadding ->
         LazyColumn(modifier = Modifier.padding(innerPadding)) {

         }
    }
}