package com.mayurappstudios.wishywishlistapp.view

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.mayurappstudios.wishywishlistapp.R

@Composable
fun AppBarView(
    title: String,
    onBackNavClicked: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier
            .heightIn(max = 45.dp),
        title = { Text(text = title, color = colorResource(id = R.color.white)) }, elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color), navigationIcon = {
            if (!title.equals("Wishy Wishlist")) {
                IconButton(onClick = onBackNavClicked) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        })
}