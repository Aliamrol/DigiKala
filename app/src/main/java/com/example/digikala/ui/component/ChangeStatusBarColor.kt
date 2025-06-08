package com.example.digikala.ui.component

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digikala.navigation.Screens
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.digikala.ui.theme.Purple200


@Composable
fun ChangeStatusBarColor(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    val statusBarColor = if(MaterialTheme.colors.isLight){
        Color.White
    }else{
        Color.Black
    }

    when (navBackStackEntry?.destination?.route) {
        Screens.Splash.route -> {
            systemUiController.setStatusBarColor(
                color = Purple200
            )
        }

        else -> {
            systemUiController.setStatusBarColor(statusBarColor)
        }
    }
}