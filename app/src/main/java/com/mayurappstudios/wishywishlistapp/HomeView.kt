package com.mayurappstudios.wishywishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mayurappstudios.wishywishlistapp.model.data.DummyWish
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
               items(DummyWish.wishList) {
                   wish-> WishItem(wish = wish) {
                   
               }}
        }
    }
}

@Composable
fun WishItem(modifier: Modifier = Modifier, wish: Wish, onClick: () -> Unit = {}){
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick()
        },  elevation = 10.dp,
        backgroundColor = Color.White) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, color = Color.Black, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }
}