package com.example.digikala.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikala.data.dataStore.DataStoreRepository
import com.example.digikala.utils.Constants.PERSIAN_LANGUAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    companion object {
        const val USER_LANGUAGE_KEY = "USER_LANGUAGE_KEY"
    }

    fun saveUserLanguage(value: String) {
        viewModelScope.launch {
            repository.putString(key = USER_LANGUAGE_KEY, value = value)
        }
    }

     fun getUserLanguage(): String =
        runBlocking { repository.getString(USER_LANGUAGE_KEY) ?: PERSIAN_LANGUAGE }


}