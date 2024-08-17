package com.mayurappstudios.wishywishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(modifier : Modifier = Modifier, wishViewModel : WishViewModel = viewModel(), navController: NavHostController = rememberNavController()){
       NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
           composable(Screen.HomeScreen.route){
                HomeView(modifier, navController, wishViewModel)
           }
           composable(Screen.AddWishScreen.route){
               AddEditDetailView(
                   modifier = modifier,
                   id = 0L,
                   wishViewModel = wishViewModel,
                   navController = navController
               )

           }
       }
}