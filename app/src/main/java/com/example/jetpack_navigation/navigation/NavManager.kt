package com.example.jetpack_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpack_navigation.views.DetailView
import com.example.jetpack_navigation.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{optional}", arguments = listOf(
            navArgument("id"){type = NavType.IntType},
        )){
            val id = it.arguments?.getInt("id") ?: 0
            val optional = it.arguments?.getString("optional")
            DetailView(navController, id, optional)
        }
    }
}