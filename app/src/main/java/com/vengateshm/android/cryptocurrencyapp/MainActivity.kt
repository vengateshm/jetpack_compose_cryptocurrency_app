package com.vengateshm.android.cryptocurrencyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vengateshm.android.cryptocurrencyapp.presentation.Screen
import com.vengateshm.android.cryptocurrencyapp.presentation.coinDetail.CoinDetailScreen
import com.vengateshm.android.cryptocurrencyapp.presentation.coinList.CoinListScreen
import com.vengateshm.android.cryptocurrencyapp.ui.theme.CryptoCurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.CoinList.route) {
                        composable(route = Screen.CoinList.route) {
                            CoinListScreen(navController)
                        }
                        composable(route = Screen.CoinDetail.route + "/{coinId}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}