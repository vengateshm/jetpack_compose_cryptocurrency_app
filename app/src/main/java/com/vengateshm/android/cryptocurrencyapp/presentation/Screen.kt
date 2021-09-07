package com.vengateshm.android.cryptocurrencyapp.presentation

sealed class Screen(val route: String) {
    object CoinList : Screen("coin_list_screen")
    object CoinDetail : Screen("coin_detail_screen")
}
