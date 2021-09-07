package com.vengateshm.android.cryptocurrencyapp.data.repository

import com.vengateshm.android.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.vengateshm.android.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.vengateshm.android.cryptocurrencyapp.data.remote.dto.CoinDto
import com.vengateshm.android.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi,
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> = coinPaprikaApi.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDto =
        coinPaprikaApi.getCoinById(coinId)
}