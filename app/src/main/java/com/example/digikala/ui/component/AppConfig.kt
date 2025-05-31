package com.example.digikala.ui.component

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.utils.Constants.USER_LANGUAGE
import com.example.digikala.viewModel.DataStoreViewModel

@Composable
fun AppConfig(
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    getDataStoreVariables(dataStore)
}


private fun getDataStoreVariables(
    dataStore: DataStoreViewModel
) {
    USER_LANGUAGE = dataStore.getUserLanguage()
}