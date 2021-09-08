package com.vengateshm.android.cryptocurrencyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vengateshm.android.cryptocurrencyapp.presentation.Screen
import com.vengateshm.android.cryptocurrencyapp.presentation.coinDetail.CoinDetailScreen
import com.vengateshm.android.cryptocurrencyapp.presentation.coinList.CoinListScreen
import com.vengateshm.android.cryptocurrencyapp.ui.theme.CryptoCurrencyAppTheme
import com.vengateshm.android.cryptocurrencyapp.ui.theme.PrimaryVariant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which means we need to through handling
        // insets
        //WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            // Update the system bars to be translucent
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = MaterialTheme.colors.isLight

            SideEffect {
                systemUiController.setStatusBarColor(PrimaryVariant,
                    darkIcons = useDarkIcons)
            }

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