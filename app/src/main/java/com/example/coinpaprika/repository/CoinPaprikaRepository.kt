package com.example.coinpaprika.repository

import com.example.coinpaprika.domain.data.DataState
import com.example.coinpaprika.domain.models.coin.*
import com.example.coinpaprika.domain.models.coin_list.CoinListItem
import com.example.coinpaprika.domain.models.global.Global
import kotlinx.coroutines.flow.Flow

interface CoinPaprikaRepository {
     fun insertCoinListItem() : Flow<DataState<Int>>
     fun getAllCoins() : Flow<DataState<List<CoinListItem>>>
     fun getGlobal() : Flow<DataState<Global>>
     fun searchCoin(query :String) : Flow<DataState<List<CoinListItem>>>
     fun getCoinById(id : String) : Flow<DataState<Coin>>
     fun getCoinEvent(id : String) : Flow<DataState<List<CoinEvent>>>
     fun getCoinExchange(id : String) : Flow<DataState<List<CoinExchangeItem>>>
     fun getCoinTwitter(id : String) : Flow<DataState<List<CoinTwitter>>>
     fun getCoinMarkets(id : String) : Flow<DataState<List<CoinMarket>>>
     fun getCoinOHLC(id : String) : Flow<DataState<OHLC>>
     fun getCoinHistoricalOHLC(id : String, start : String) : Flow<DataState<List<CoinHistoricalOHLC>>>
}