package com.example.jetpack_navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(
    name: String
) {
    Text(text = name, fontSize = 25.sp, color = Color.White)
}


@Composable
fun FAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.Gray,
        contentColor = Color.White
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "AddBtn")
    }
}


@Composable
fun MainIconButton(
    icon: ImageVector,
    onClick: () -> Unit
){
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = "btn", tint = Color.White)
    }
}