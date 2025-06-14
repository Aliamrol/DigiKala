package com.example.digikala.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikala.data.model.category.SubCategory
import com.example.digikala.data.remote.NetworkResults
import com.example.digikala.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    val subCategory = MutableStateFlow<NetworkResults<SubCategory>>(NetworkResults.Loading())

    fun getAllDataFromServer() {
        viewModelScope.launch {

            launch {
                subCategory.emit(repository.getSubCategories())
            }

        }
    }

}