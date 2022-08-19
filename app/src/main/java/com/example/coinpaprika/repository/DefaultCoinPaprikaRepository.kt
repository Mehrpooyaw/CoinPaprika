package com.example.coinpaprika.repository

import android.util.Log
import com.example.coinpaprika.data_source.LocalSource
import com.example.coinpaprika.domain.data.DataState
import com.example.coinpaprika.domain.models.coin.*
import com.example.coinpaprika.domain.models.coin_list.CoinListItem
import com.example.coinpaprika.domain.models.coin_list.toDao
import com.example.coinpaprika.domain.models.coin_list.toDomain
import com.example.coinpaprika.domain.models.global.Global
import com.example.coinpaprika.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class DefaultCoinPaprikaRepository : CoinPaprikaRepository,KoinComponent {
    private val networkService : NetworkService = get(null)
    private val localSource : LocalSource = get(null)
    override  fun insertCoinListItem() = flow<DataState<Int>> {
        emit(DataState.loading())
        try {
            emit(DataState.loadingFloat("0.0"))
            val network = networkService.getCoinList()
            network.forEachIndexed() { index, it ->
                emit(DataState.loadingFloat((index* 100f /network.size).toString()))
                localSource.insertCoinListItem(it.toDao())

            }
            emit(DataState.success(1))
        }catch (e : Exception){
            println("AppDebug: ${e.message}")
        }
    }

    override fun getAllCoins(): Flow<DataState<List<CoinListItem>>> = flow {
        emit(DataState.loading())
        try {
            emit(DataState.success(localSource.selectAllCoins().toDomain()))

        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }

    }

    override  fun getGlobal(): Flow<DataState<Global>> = flow{
 emit(DataState.loading())
    try {
        emit(DataState.success(networkService.getGlobal()))
            
        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }
    }

    override  fun searchCoin(query : String): Flow<DataState<List<CoinListItem>>> = flow{
    emit(DataState.loading())
        try {
            emit(DataState.success(localSource.searchCoinListItem(query).toDomain()))
        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }
    }

    override  fun getCoinById(id: String): Flow<DataState<Coin>> = flow{
        emit(DataState.loading())
        try {
            emit(DataState.success(networkService.getCoinById(id)))

            
        }catch (e : Exception){
            Log.d("AppDebug", "getCoinById: ${e.message} ")
            emit(DataState.error(e.message?:"Unknown error."))
        }
    }

    override  fun getCoinEvent(id: String): Flow<DataState<List<CoinEvent>>> = flow{
        emit(DataState.loading())
        try {
            emit(DataState.success(networkService.getCoinEvent(id)))
        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }    }

    override  fun getCoinExchange(id: String): Flow<DataState<List<CoinExchangeItem>>> = flow{
        emit(DataState.loading())
        try {
            emit(DataState.success(networkService.getCoinExchange(id)))

        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }    }

    override  fun getCoinTwitter(id: String): Flow<DataState<List<CoinTwitter>>> = flow{
        emit(DataState.loading())
        try {
            emit(DataState.success(networkService.getCoinTwitter(id)))
        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }    }

    override  fun getCoinMarkets(id: String): Flow<DataState<List<CoinMarket>>> = flow{
        emit(DataState.loading())
        try {
            emit(DataState.success(networkService.getCoinMarkets(id)))


        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }    }

    override  fun getCoinOHLC(id: String): Flow<DataState<OHLC>> = flow{
        emit(DataState.loading())
        try {
            emit(DataState.success(networkService.getCoinOHLC(id)))


        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }    }

    override  fun getCoinHistoricalOHLC(
        id: String,
        start: String,
    ): Flow<DataState<List<CoinHistoricalOHLC>>> = flow{
        emit(DataState.loading())
        try {
            emit(DataState.success(networkService.getCoinHistoricalOHLC(id,start)))

        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }    }
}