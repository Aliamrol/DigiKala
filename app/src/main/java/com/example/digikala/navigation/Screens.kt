package com.example.digikala.navigation

sealed class Screens(val route: String) {
    object Splash : Screens("splash_screen")
    object Home : Screens("home_screen")
    object Category : Screens("category_screen")
    object Basket : Screens("basket_screen")
    object Profile : Screens("profile_screen")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
