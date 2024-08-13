package com.mayurappstudios.wishywishlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Scaffold(modifier = modifier, topBar = {
        AppBarView(title = "Wishy Wishlist", {
            Toast.makeText(context, "Back Button Clicked", Toast.LENGTH_SHORT).show()
        })
    }) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {

        }
    }
}