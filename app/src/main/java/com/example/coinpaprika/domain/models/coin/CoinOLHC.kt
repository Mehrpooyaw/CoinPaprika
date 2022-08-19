package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinOHLC(
    @SerialName("close")
    val close: Double? = null,
    @SerialName("high")
    val high: Double? = null,
    @SerialName("low")
    val low: Double? = null,
    @SerialName("market_cap")
    val marketCap: Long? = null,
    @SerialName("open")
    val `open`: Double? = null,
    @SerialName("time_close")
    val timeClose: String? = null,
    @SerialName("time_open")
    val timeOpen: String? = null,
    @SerialName("volume")
    val volume: Int? = null
)