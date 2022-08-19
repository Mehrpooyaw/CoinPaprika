package com.example.coinpaprika.presentation.ui.coin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpaprika.domain.models.coin.*
import com.example.coinpaprika.repository.CoinPaprikaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoinViewModel(
    private val repository: CoinPaprikaRepository
) : ViewModel() {
    var loading by mutableStateOf(false)
    var forceLoading by mutableStateOf(false)
    var coin by mutableStateOf<Coin?>(null)
    var errorMessages = mutableStateListOf<String?>()
    val coinEvent = mutableStateListOf<CoinEvent?>(null)
    val coinTwitter = mutableStateListOf<CoinTwitter?>(null)
    val coinExchanges = mutableStateListOf<CoinExchangeItem?>(null)
    val coinMarkets = mutableStateListOf<CoinMarket?>(null)
    var coinOHLC = mutableStateOf<OHLC?>(null)
    var isFavorite by mutableStateOf(false)






    fun initialize(id : String) {
            runBlocking {
                getCoin(id)
//                getCoinExchanges(id)
                getCoinEvent(id)
                getCoinMarkets(id)
                getCoinTwitter(id)
        }
    }


    private fun getCoinOHLC(id : String){
        repository.getCoinOHLC(id).onEach {
            loading = it.loading
            errorMessages.add(it.error)
            it.data?.let { data ->
                coinOHLC.value = data
            }
        }.launchIn(viewModelScope)
    }


    private fun getCoinMarkets(id : String){
        repository.getCoinMarkets(id).onEach {
            loading = it.loading
            errorMessages.add(it.error)
            it.data?.let { data ->
                coinMarkets.clear()
                coinMarkets.addAll(data)
            }
        }.launchIn(viewModelScope)
    }



    private fun getCoinExchanges(id : String){
        repository.getCoinExchange(id).onEach {
            loading = it.loading
            errorMessages.add(it.error)
            it.data?.let { data ->
                coinExchanges.clear()
                coinExchanges.addAll(data)
            }
        }.launchIn(viewModelScope)
    }



    private fun getCoinTwitter(id : String){
        repository.getCoinTwitter(id).onEach {
            loading = it.loading
            errorMessages.add(it.error)
            it.data?.let { data ->
                coinTwitter.clear()
                coinTwitter.addAll(data)
            }
        }.launchIn(viewModelScope)
    }


    private fun getCoinEvent(id : String){
        repository.getCoinEvent(id).onEach {
            loading = it.loading
            errorMessages.add(it.error)
            it.data?.let { data ->
                coinEvent.clear()
                coinEvent.addAll(data)
            }
        }.launchIn(viewModelScope)

    }

    private fun getCoin(id : String){
        repository.getCoinById(id).onEach { state ->
            loading = state.loading
            errorMessages.add(state.error)
            state.data?.let { data ->
                coin = data
                data.symbol?.let { getCoinOHLC(it) }
                isFavorite = data.isFavorite
            }
        }.launchIn(viewModelScope)
    }
}