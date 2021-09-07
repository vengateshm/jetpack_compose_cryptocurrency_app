package com.vengateshm.android.cryptocurrencyapp.presentation.coinDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vengateshm.android.cryptocurrencyapp.common.Constants.PARAM_COIN_ID
import com.vengateshm.android.cryptocurrencyapp.common.Resource
import com.vengateshm.android.cryptocurrencyapp.domain.useCases.getCoin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _coinDetailState = mutableStateOf(CoinDetailState())
    val coinDetailState: State<CoinDetailState> = _coinDetailState

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _coinDetailState.value = CoinDetailState(coinDetail = result.mData)
                }
                is Resource.Error -> {
                    _coinDetailState.value =
                        CoinDetailState(error = result.mMessage ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _coinDetailState.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}