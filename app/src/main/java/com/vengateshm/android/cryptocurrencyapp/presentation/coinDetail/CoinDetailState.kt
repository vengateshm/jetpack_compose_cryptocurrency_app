package com.vengateshm.android.cryptocurrencyapp.presentation.coinDetail

import com.vengateshm.android.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail?=null,
    val error: String = "",
)