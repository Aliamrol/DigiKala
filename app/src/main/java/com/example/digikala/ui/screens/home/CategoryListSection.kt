package com.example.digikala.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.digikala.R
import com.example.digikala.data.model.home.MainCategory
import com.example.digikala.data.remote.NetworkResults
import com.example.digikala.log
import com.example.digikala.ui.theme.darkText
import com.example.digikala.ui.theme.spacing
import com.example.digikala.viewModel.DeviceInfoViewModel
import com.example.digikala.viewModel.HomeViewModel

@Composable
fun CategoryListSection(
    viewModel: HomeViewModel = hiltViewModel(),
) {

    var categoriesList by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val categoriesResult by viewModel.categories.collectAsState()

    when (categoriesResult) {
        is NetworkResults.Success -> {
            categoriesList = categoriesResult.data ?: emptyList()
            loading = false
        }

        is NetworkResults.Error -> {
            loading = false
            log("Category Section Error!")
        }

        is NetworkResults.Loading -> {
            loading = true

        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small),
    ) {
        Text(
            text = stringResource(R.string.category_title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.medium),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        FlowRow(
            maxItemsInEachRow = 3, modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            for (item in categoriesList) {
                CircularCategoryItem(item)
            }
        }
    }
}

@Composable
fun CircularCategoryItem(
    item: MainCategory,
    deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.size(
            width = (deviceInfoViewModel.screenWidth * 0.24).dp,
            height = (deviceInfoViewModel.screenHeight * 0.20).dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = rememberAsyncImagePainter(item.image),
            contentDescription = "",
            modifier = Modifier
                .width((deviceInfoViewModel.screenWidth * 0.24).dp)
                .height((deviceInfoViewModel.screenHeight * 0.12).dp)
                .padding(vertical = MaterialTheme.spacing.extraSmall)
        )

        Text(
            text = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.extraSmall),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}