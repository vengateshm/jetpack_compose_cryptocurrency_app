package com.vengateshm.android.cryptocurrencyapp.presentation.coinList

import com.vengateshm.android.cryptocurrencyapp.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
)
