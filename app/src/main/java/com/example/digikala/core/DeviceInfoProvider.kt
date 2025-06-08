package com.example.digikala.core

import android.content.Context

class DeviceInfoProvider(private val context: Context) {
    val screenWidthDp: Int
        get() = context.resources.configuration.screenWidthDp

    val screenHeightDp: Int
        get() = context.resources.configuration.screenHeightDp
}