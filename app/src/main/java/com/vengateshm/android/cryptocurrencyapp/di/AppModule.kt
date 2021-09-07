package com.vengateshm.android.cryptocurrencyapp.di

import com.vengateshm.android.cryptocurrencyapp.common.Constants
import com.vengateshm.android.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.vengateshm.android.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.vengateshm.android.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // All dependencies in this module live as long as the application is alive
object AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)
}