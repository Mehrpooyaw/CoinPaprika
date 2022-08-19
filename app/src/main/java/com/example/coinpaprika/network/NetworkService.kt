package com.example.coinpaprika.network

import com.example.coinpaprika.domain.data.DataState
import com.example.coinpaprika.domain.models.coin.*
import com.example.coinpaprika.domain.models.coin_list.CoinListItem
import com.example.coinpaprika.domain.models.global.Global
import kotlinx.coroutines.flow.Flow

interface NetworkService {
    suspend fun getGlobal() : Global
    suspend fun getCoinList() : List<CoinListItem>
    suspend fun getCoinById(id : String) : Coin
    suspend fun getCoinEvent(id : String) : List<CoinEvent>
    suspend fun getCoinExchange(id : String) : List<CoinExchangeItem>
    suspend fun getCoinTwitter(id : String) : List<CoinTwitter>
    suspend fun getCoinMarkets(id : String) : List<CoinMarket>
    suspend fun getCoinOHLC(id : String) : OHLC
    suspend fun getCoinHistoricalOHLC(id : String, start : String) : List<CoinHistoricalOHLC>
}
