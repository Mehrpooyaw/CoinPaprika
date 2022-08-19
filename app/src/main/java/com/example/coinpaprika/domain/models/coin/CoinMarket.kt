package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinMarket(
    @SerialName("adjusted_volume_24h_share")
    val adjustedVolume24hShare: Double? = null,
    @SerialName("base_currency_id")
    val baseCurrencyId: String? = null,
    @SerialName("base_currency_name")
    val baseCurrencyName: String? = null,
    @SerialName("category")
    val category: String? = null,
    @SerialName("exchange_id")
    val exchangeId: String? = null,
    @SerialName("exchange_name")
    val exchangeName: String? = null,
    @SerialName("fee_type")
    val feeType: String? = null,
    @SerialName("last_updated")
    val lastUpdated: String? = null,
    @SerialName("market_url")
    val marketUrl: String? = null,
    @SerialName("outlier")
    val outlier: Boolean? = null,
    @SerialName("pair")
    val pair: String? = null,
    @SerialName("quote_currency_id")
    val quoteCurrencyId: String? = null,
    @SerialName("quote_currency_name")
    val quoteCurrencyName: String? = null,
    @SerialName("quotes")
    val quotes: com.example.coinpaprika.domain.models.coin.Quotes? = null
)