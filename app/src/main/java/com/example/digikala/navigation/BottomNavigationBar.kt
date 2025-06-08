package com.example.digikala.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digikala.R
import com.example.digikala.ui.theme.bottomBar
import com.example.digikala.ui.theme.selectedBottomBar
import com.example.digikala.ui.theme.unSelectedBottomBar
import com.example.digikala.utils.Constants
import com.example.digikala.utils.LocaleUtils
import com.example.digikala.viewModel.DeviceInfoViewModel

@Composable
fun BottomNavigationBar(
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit,
    deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()
) {

    LocaleUtils.setLocale(LocalContext.current, Constants.USER_LANGUAGE)

    val items = listOf(
        BottomNavItem(
            name = stringResource(R.string.home),
            route = Screens.Home.route,
            selectedIcon = painterResource(R.drawable.home_fill),
            deSelectedIcon = painterResource(R.drawable.home_outline),
        ), BottomNavItem(
            name = stringResource(R.string.category),
            route = Screens.Category.route,
            selectedIcon = painterResource(R.drawable.category_fill),
            deSelectedIcon = painterResource(R.drawable.category_outline),
        ), BottomNavItem(
            name = stringResource(R.string.basket),
            route = Screens.Basket.route,
            selectedIcon = painterResource(R.drawable.cart_fill),
            deSelectedIcon = painterResource(R.drawable.cart_outline),
        ), BottomNavItem(
            name = stringResource(R.string.my_digikala),
            route = Screens.Profile.route,
            selectedIcon = painterResource(R.drawable.user_fill),
            deSelectedIcon = painterResource(R.drawable.user_outline)
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.route }

    if (showBottomBar) {
        BottomNavigation(
            modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.07).dp),
            backgroundColor = MaterialTheme.colors.bottomBar,
            elevation = 5.dp
        ) {
            items.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colors.selectedBottomBar,
                    unselectedContentColor = MaterialTheme.colors.unSelectedBottomBar,
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            if (selected) {
                                Icon(
                                    modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.04).dp),
                                    painter = item.selectedIcon,
                                    contentDescription = item.name,
                                )
                            } else {
                                Icon(
                                    modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.03).dp),
                                    painter = item.deSelectedIcon,
                                    contentDescription = item.name
                                )
                            }
                            if (selected) {
                                Text(
                                    item.name,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.Bold,
                                )
                            } else {
                                Text(
                                    item.name,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.W100,
                                )
                            }

                        }
                    },
                )
            }
        }
    }
}