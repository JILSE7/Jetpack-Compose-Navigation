package com.example.jetpack_navigation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.jetpack_navigation.components.FAB
import com.example.jetpack_navigation.components.MainButton
import com.example.jetpack_navigation.components.MainIconButton
import com.example.jetpack_navigation.components.Space
import com.example.jetpack_navigation.components.TitleBar
import com.example.jetpack_navigation.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController, id:Int, optional: String?) {
    val navigateHome = fun(){navController.navigate("Home")}
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.DarkGray
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navigateHome()
                    }
                }
            )
        },
        floatingActionButton = { FAB() }
    ) {
        ContentDetailView(navigateHome, id, optional)
    }
}

@Composable
fun ContentDetailView(navigateHome: () -> Unit, id: Int,  optional: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TitleView(name = "DETAIL VIEW $id $optional")
        Space()
        MainButton(name = "Home View", backgroundColor = Color.Cyan, color = Color.Black) {
            println("SOY UN BTN GENERIC")
            navigateHome()
        }
    }
}