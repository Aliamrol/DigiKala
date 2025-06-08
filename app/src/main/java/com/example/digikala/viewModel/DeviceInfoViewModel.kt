package com.example.digikala.viewModel

import androidx.lifecycle.ViewModel
import com.example.digikala.core.DeviceInfoProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DeviceInfoViewModel @Inject constructor(
    deviceInfoProvider: DeviceInfoProvider
) : ViewModel() {

    val screenWidth = deviceInfoProvider.screenWidthDp
    val screenHeight = deviceInfoProvider.screenHeightDp
}