package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinExchangeItem(
    @SerialName("adjusted_volume_24h_share")
    val adjustedVolume24hShare: Double? = null,
    @SerialName("fiats")
    val fiats: List<com.example.coinpaprika.domain.models.coin.Fiat?>? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null
)