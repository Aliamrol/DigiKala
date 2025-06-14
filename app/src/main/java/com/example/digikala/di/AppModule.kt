package com.example.digikala.di

import android.content.Context
import com.example.digikala.core.DeviceInfoProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDeviceInfoProvider(
        @ApplicationContext context: Context
    ): DeviceInfoProvider = DeviceInfoProvider(context)
}