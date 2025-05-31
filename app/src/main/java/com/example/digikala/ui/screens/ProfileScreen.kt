package com.example.digikala.ui.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.digikala.MainActivity
import com.example.digikala.utils.Constants.ENGLISH_LANGUAGE
import com.example.digikala.utils.Constants.PERSIAN_LANGUAGE
import com.example.digikala.viewModel.DataStoreViewModel

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileScreen(
    navController: NavHostController, dataStore: DataStoreViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val activity = LocalContext.current as Activity

        Text("ProfileScreen")

        Button(
            onClick = {
                dataStore.saveUserLanguage(PERSIAN_LANGUAGE)
                activity.apply {
                    activity.finish()
                    activity.startActivity(Intent(activity, MainActivity::class.java))
                }
            }) {
            Text(text = PERSIAN_LANGUAGE)
        }
        Button(
            onClick = {
                dataStore.saveUserLanguage(ENGLISH_LANGUAGE)
                activity.apply {
                    activity.finish()
                    activity.startActivity(Intent(activity, MainActivity::class.java))
                }
            }) {
            Text(text = ENGLISH_LANGUAGE)
        }

    }
}