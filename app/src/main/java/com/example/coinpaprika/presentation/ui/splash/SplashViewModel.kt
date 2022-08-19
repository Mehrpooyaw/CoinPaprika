package com.example.coinpaprika.presentation.ui.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpaprika.repository.CoinPaprikaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repository: CoinPaprikaRepository
) :ViewModel() {
    var loadingFloat by mutableStateOf<String?>(null)
    var shouldNavigate by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    init {
        insertCoins()
    }
    private fun insertCoins(){
        repository.insertCoinListItem().onEach {
            viewModelScope.launch {
                loadingFloat = it.loadingPercentageFloat
            }
            it.data?.let {
                shouldNavigate = true
            }
            it.error?.let { error ->
                errorMessage = error
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }



}