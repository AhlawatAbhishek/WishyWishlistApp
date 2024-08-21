package com.mayurappstudios.wishywishlistapp

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddEditDetailView(
    modifier: Modifier = Modifier,
    id: Long,
    wishViewModel: WishViewModel,
    navController: NavController
) {
    Log.d("Receiving WishId: ", id.toString())
    val snackMessage = remember{
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = modifier,
        topBar = {
        AppBarView(
            title = (if (id != 0L) stringResource(id = R.string.update_wish)
            else stringResource(id = R.string.add_wish)), {
                navController.navigateUp()
            }
        )
    }) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WishTextField(
                label = "Title",
                value = wishViewModel.wishTitleState.value,
                onValueChanged = { wishTitle ->
                    wishViewModel.onWishTitleChanged(wishTitle)
                })
            Spacer(Modifier.height(10.dp))
            WishTextField(
                label = "Description",
                value = wishViewModel.wishDescriptionState.value,
                onValueChanged = { wishDescription ->
                    wishViewModel.onWishDescriptionChanged(wishDescription)
                })
            Spacer(Modifier.height(10.dp))
            Button(onClick = {
                if (wishViewModel.wishTitleState.value.isNotEmpty() && wishViewModel.wishDescriptionState.value.isNotEmpty()) {
                    //TODO : Save the wish
                } else {
                    //TODO: Add wish
                }
//                navController.popBackStack()
            }) {
                Text(
                    text = if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(
                        id = R.string.add_wish
                    )
                )
            }
        }
    }
}

@Composable
fun WishTextField(label: String, value: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black,
            textColor = Color.Black,
            cursorColor = Color.Green
        )
    )
}

@Preview(showBackground = true)
@Composable
fun WishTextFieldPreview() {
    WishTextField(label = "Title", value = "Title of Wish", onValueChanged = {})
}