package com.vengateshm.android.cryptocurrencyapp.presentation.coinList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vengateshm.android.cryptocurrencyapp.common.Resource
import com.vengateshm.android.cryptocurrencyapp.domain.useCases.getCoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    private val _coinListState = mutableStateOf(CoinsListState())
    val coinListState: State<CoinsListState> = _coinListState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _coinListState.value = CoinsListState(coins = result.mData ?: emptyList())
                }
                is Resource.Error -> {
                    _coinListState.value =
                        CoinsListState(error = result.mMessage ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _coinListState.value = CoinsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}