package com.example.coinpaprika.network

import android.util.Log
import com.example.coinpaprika.domain.models.coin.*
import com.example.coinpaprika.domain.models.coin_list.CoinListItem
import com.example.coinpaprika.domain.models.global.Global
import com.example.coinpaprika.util.Constants.Companion.BASE_URL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class DefaultNetworkService : NetworkService {
    override suspend fun getGlobal(): Global = withContext(Dispatchers.IO) {
         ktorHttpClient.get("$BASE_URL/global").body()
    }

    override suspend fun getCoinList(): List<CoinListItem> = withContext(Dispatchers.IO) {
        ktorHttpClient.get("$BASE_URL/coins").body()
    }

    override suspend fun getCoinById(id: String): Coin = withContext(Dispatchers.IO) {
        ktorHttpClient.get("$BASE_URL/coins/$id").body()
    }

    override suspend fun getCoinEvent(id: String): List<CoinEvent> = withContext(Dispatchers.IO) {
        ktorHttpClient.get("$BASE_URL/coins/$id/events").body()
    }

    override suspend fun getCoinExchange(id: String): List<CoinExchangeItem> = withContext(Dispatchers.IO) {
        ktorHttpClient.get("$BASE_URL/coins/$id/exchanges").body()
    }

    override suspend fun getCoinTwitter(id: String): List<CoinTwitter> = withContext(Dispatchers.IO) {
        ktorHttpClient.get("$BASE_URL/coins/$id/twitter").body()
    }

    override suspend fun getCoinMarkets(id: String): List<CoinMarket> = withContext(Dispatchers.IO) {
        ktorHttpClient.get("$BASE_URL/coins/$id/markets").body()
    }

    override suspend fun getCoinOHLC(id: String): OHLC = withContext(Dispatchers.IO) {
        ktorHttpClient.get("https://api.cryptowat.ch/markets/binance/${id}usdt/ohlc").body()
    }

    override suspend fun getCoinHistoricalOHLC(
        id: String,
        start: String,
    ): List<CoinHistoricalOHLC> = withContext(Dispatchers.IO) {
        ktorHttpClient.get("$BASE_URL/coins/$id/ohlcv/historical?start=$start").body()
    }

}
private val ktorHttpClient = HttpClient(Android){
    install(ContentNegotiation){
        json(
            Json{
                prettyPrint = true
                ignoreUnknownKeys = true
                isLenient = true
            }
        )
        engine {
            connectTimeout = 10000
            socketTimeout = 10000
        }
    }
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("AppDebug, Logger Ktor -->", message)
            }
        }
        level = LogLevel.ALL
    }
    install(ResponseObserver) {
        onResponse { res ->
            Log.d("AppDebug, HTTP status: -->",res.status.value.toString())
        }
    }
    install(DefaultRequest){
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}





