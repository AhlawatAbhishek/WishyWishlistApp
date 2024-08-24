package com.mayurappstudios.wishywishlistapp

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mayurappstudios.wishywishlistapp.model.data.Wish

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    wishViewModel: WishViewModel? = null
) {
    val context = LocalContext.current
    Scaffold(containerColor = Color.LightGray, modifier = modifier, topBar = {
        AppBarView(title = "Wishy Wishlist")
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Floating Action Button Clicked", Toast.LENGTH_SHORT)
                        .show()
                    navController?.navigate(Screen.AddWishScreen.route + "/0L")
                },
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                containerColor = Color.Red,
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }) { innerPadding ->
        val wishList = wishViewModel?.getAllWishes?.collectAsState(initial = listOf())
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            if (wishList != null) {
                items(wishList.value, key = { wish -> wish.id }) { wish ->
                    val dismissState = rememberDismissState(
                        confirmStateChange = {
                            if (it == DismissValue.DismissedToStart || it == DismissValue.DismissedToEnd) {
                                wishViewModel?.deleteWish(wish)
                            }
                            true
                        }
                    )
                    SwipeToDismiss(state = dismissState, background = {
                        val bgColor by animateColorAsState(
                            targetValue = if (dismissState.dismissDirection == DismissDirection.StartToEnd || dismissState.dismissDirection == DismissDirection.EndToStart) {
                                Color.Red
                            } else {
                                Color.White
                            }, label = "Color Animation"
                        )
                        val alignment = Alignment.CenterEnd
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(bgColor)
                                .padding(horizontal = 20.dp),
                            contentAlignment = alignment
                        ) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "Delete Icon",
                                tint = Color.White
                            )
                        }
                    }, directions = setOf(
                        DismissDirection.StartToEnd, DismissDirection.EndToStart
                    ), dismissThresholds = { FractionalThreshold(0.25f) },
                        dismissContent = {
                            WishItem(wish = wish) {
                                navController?.navigate(Screen.AddWishScreen.route + "/${wish.id}")
                            }
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun WishItem(modifier: Modifier = Modifier, wish: Wish, onClick: () -> Unit = {}) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable {
                onClick()
            }, elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, color = Color.Black, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }
}