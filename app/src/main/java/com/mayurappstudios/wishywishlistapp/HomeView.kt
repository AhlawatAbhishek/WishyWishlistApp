package com.mayurappstudios.wishywishlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mayurappstudios.wishywishlistapp.model.data.Wish

@Composable
fun HomeView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Scaffold(modifier = modifier, topBar = {
        AppBarView(title = "Wishy Wishlist", {
            Toast.makeText(context, "Back Button Clicked", Toast.LENGTH_SHORT).show()
        })
    },
        floatingActionButton = {
               FloatingActionButton(onClick = {
                     Toast.makeText(context, "Floating Action Button Clicked", Toast.LENGTH_SHORT).show()
               }, modifier = Modifier.padding(all = 20.dp),
                   contentColor = Color.White,
                   containerColor =  Color.Red,) {
                   Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
               }
        }) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {

        }
    }
}

@Composable
fun WishItem(modifier: Modifier = Modifier, wish: Wish, onClick: () -> Unit){

}