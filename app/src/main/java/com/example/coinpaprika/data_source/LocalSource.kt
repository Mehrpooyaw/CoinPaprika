package com.example.coinpaprika.data_source

import com.example.coinpaprika.db.CoinListItem

interface LocalSource {
    suspend fun insertCoinListItem(item : CoinListItem)

    suspend fun searchCoinListItem(query : String) : List<CoinListItem>

    suspend fun selectAllCoins() : List<CoinListItem>
}