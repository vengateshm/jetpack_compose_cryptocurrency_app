package com.vengateshm.android.cryptocurrencyapp.domain.repository

import com.vengateshm.android.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.vengateshm.android.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}