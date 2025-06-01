package com.example.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digikala.navigation.BottomNavigationBar
import com.example.digikala.navigation.SetUpNavGraph
import com.example.digikala.ui.component.AppConfig
import com.example.digikala.ui.component.ChangeStatusBarColor
import com.example.digikala.utils.Constants.ENGLISH_LANGUAGE
import com.example.digikala.utils.Constants.USER_LANGUAGE
import com.example.digikala.utils.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint
import ir.truelearn.digikala.ui.theme.DigikalaTheme

@AndroidEntryPoint
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
                ChangeStatusBarColor(navController)

                AppConfig()


                LocaleUtils.setLocale(context = LocalContext.current, language = USER_LANGUAGE)


                val direction = if (USER_LANGUAGE == ENGLISH_LANGUAGE) {
                    LayoutDirection.Ltr
                } else {
                    LayoutDirection.Rtl
                }



                CompositionLocalProvider(LocalLayoutDirection provides direction) {
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
}


fun log(msg: String) {
    Log.e("1313", msg)
}
