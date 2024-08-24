package com.mayurappstudios.wishywishlistapp.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mayurappstudios.wishywishlistapp.viewmodel.WishViewModel

@Composable
fun Navigation(modifier : Modifier = Modifier, wishViewModel : WishViewModel = viewModel(), navController: NavHostController = rememberNavController()){
       NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
           composable(Screen.HomeScreen.route){
                HomeView(modifier, navController, wishViewModel)
           }
           composable(Screen.AddWishScreen.route + "/{wishId}"){ backStackEntry ->
               val wishId = (backStackEntry.arguments?.getString("wishId") ?: "0L").toLongOrNull() ?: 0L
               Log.d("Navigation Sending WishId: ", wishId.toString())
               AddEditDetailView(
                   modifier = modifier,
                   id = wishId,
                   wishViewModel = wishViewModel,
                   navController = navController
               )

           }
       }
}