package com.example.coinpaprika.data_source

import com.example.coinpaprika.Database
import com.example.coinpaprika.db.CoinListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DefaultLocalSource(
    database : Database
) : LocalSource {
    private val dao = database.coinListItemQueries
    override suspend fun insertCoinListItem(item: CoinListItem) = withContext(Dispatchers.IO) {
        dao.insert(item)
    }

    override suspend fun searchCoinListItem(query: String): List<CoinListItem> = withContext(Dispatchers.IO) {
        dao.search(query).executeAsList()
    }

    override suspend fun selectAllCoins(): List<CoinListItem> = withContext(Dispatchers.IO) {
       dao.selectAll().executeAsList()
    }
}