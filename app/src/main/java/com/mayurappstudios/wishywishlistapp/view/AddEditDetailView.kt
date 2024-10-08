package com.mayurappstudios.wishywishlistapp.view

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
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.mayurappstudios.wishywishlistapp.R
import com.mayurappstudios.wishywishlistapp.viewmodel.WishViewModel
import com.mayurappstudios.wishywishlistapp.model.data.Wish
import kotlinx.coroutines.launch

@Composable
fun AddEditDetailView(
    modifier: Modifier = Modifier,
    id: Long,
    wishViewModel: WishViewModel,
    navController: NavController
) {
    Log.d("Receiving WishId: ", id.toString())
    val snackMessage = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    if (id != 0L) {
        val wish = wishViewModel.getAWishById(id.toInt())
            .collectAsState(initial = Wish(id = 0, title = "", description = "")).value
        wishViewModel.onWishTitleChanged(wish.title)
        wishViewModel.onWishDescriptionChanged(wish.description)
    } else {
        wishViewModel.onWishTitleChanged("")
        wishViewModel.onWishDescriptionChanged("")
    }
    Scaffold(
        modifier = modifier,
        topBar = {
            AppBarView(
                title = (if (id != 0L) stringResource(id = R.string.update_wish)
                else stringResource(id = R.string.add_wish)), {
                    navController.navigateUp()
                }
            )
        }, scaffoldState = scaffoldState
    ) { innerPadding ->
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
                if (wishViewModel.wishTitleState.value.isNotEmpty()
                    && wishViewModel.wishDescriptionState.value.isNotEmpty()
                ) {
                    //TODO : Save the wish
                    //TODO: Add wish
                    if (id == 0L) {
                        //TODO: Add wish
                        wishViewModel.addWish(
                            Wish(
                                title = wishViewModel.wishTitleState.value.trim(),
                                description = wishViewModel.wishDescriptionState.value.trim()
                            )
                        )
                        snackMessage.value = "Wish Added Successfully"
                    } else {
                        //TODO: Update wish
                        wishViewModel.updateWish(
                            Wish(
                                id = id,
                                title = wishViewModel.wishTitleState.value.trim(),
                                description = wishViewModel.wishDescriptionState.value.trim()
                            )
                        )
                        snackMessage.value = "Wish Updated Successfully"
                    }
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                        navController.navigateUp()
                    }
                } else {
                    snackMessage.value = "Please fill all the fields, to create a wish"
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                    }
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