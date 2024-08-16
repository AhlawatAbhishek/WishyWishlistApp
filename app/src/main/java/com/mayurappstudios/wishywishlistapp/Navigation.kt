package com.mayurappstudios.wishywishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(modifier : Modifier = Modifier, viewModel : WishViewModel = viewModel(), navController: NavHostController = rememberNavController()){
       NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
           composable("home_screen"){
                HomeView(modifier)
           }
       }
}