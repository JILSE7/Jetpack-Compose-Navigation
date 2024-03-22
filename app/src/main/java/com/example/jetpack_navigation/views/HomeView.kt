package com.example.jetpack_navigation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.jetpack_navigation.components.FAB
import com.example.jetpack_navigation.components.MainButton
import com.example.jetpack_navigation.components.Space
import com.example.jetpack_navigation.components.TitleBar
import com.example.jetpack_navigation.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {

    val navigateDetail = fun(id: Int, optional: String?){navController.navigate("Detail/${id}/?${optional}")}
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Gray
                )
            )
        },
        floatingActionButton = { FAB()}
    ) {
        ContentHomeView(navigateDetail)
    }
}

@Composable
fun ContentHomeView( navigateDetail: (Int,  String?) -> Unit) {
    var optional by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "HOME VIEW")
        Space()
        TextField(value = optional, onValueChange = {optional = it }, label = { Text(text = "Optional  ")})
        Text(text = optional)
        MainButton(name = "Detail View", backgroundColor = Color.Cyan, color = Color.Black) {
            println("SOY UN BTN GENERIC")
            navigateDetail(174, optional )
        }
        Space()
        MainButton(name = "Segundo btn", backgroundColor = Color.Magenta, color = Color.Black, onClick = { println("HOLA AMIGOS") })
    }
}