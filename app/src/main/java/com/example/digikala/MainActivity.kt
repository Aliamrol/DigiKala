package com.example.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digikala.navigation.BottomNavigationBar
import com.example.digikala.navigation.SetUpNavGraph
import ir.truelearn.digikala.ui.theme.DigikalaTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint(
        "UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            DigikalaTheme {
                navController = rememberNavController()


                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding(), bottomBar = {
                        BottomNavigationBar(navController = navController, onItemClick = {
                            navController.navigate(it.route)
                        })
                    }) {
                    SetUpNavGraph(navController = navController)

                }


            }

        }
    }
}
