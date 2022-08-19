package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinksExtended(
    @SerialName("stats")
    val stats: com.example.coinpaprika.domain.models.coin.Stats? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("url")
    val url: String? = null
)