package com.vengateshm.android.cryptocurrencyapp.domain.useCases.getCoins

import com.vengateshm.android.cryptocurrencyapp.common.Resource
import com.vengateshm.android.cryptocurrencyapp.data.remote.dto.toCoin
import com.vengateshm.android.cryptocurrencyapp.domain.model.Coin
import com.vengateshm.android.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success<List<Coin>>(coins.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}