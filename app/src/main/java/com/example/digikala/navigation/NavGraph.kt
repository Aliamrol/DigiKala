package com.example.digikala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.digikala.ui.screens.BasketScreen
import com.example.digikala.ui.screens.category.CategoryScreen
import com.example.digikala.ui.screens.ProfileScreen
import com.example.digikala.ui.screens.SplashScreen
import com.example.digikala.ui.screens.home.HomeScreen
import com.example.digikala.ui.screens.home.WebPageScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.Splash.route) {

        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screens.Category.route) {
            CategoryScreen(navController = navController)
        }

        composable(route = Screens.Basket.route) {
            BasketScreen(navController = navController)
        }

        composable(route = Screens.Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(
            route = Screens.WebView.route + "?url={url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ) {
            val url = it.arguments?.getString("url")
            url?.let {
                WebPageScreen(navController = navController, url = url)
            }
        }

    }
}