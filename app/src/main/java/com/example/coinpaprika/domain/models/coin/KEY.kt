package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KEY(
    @SerialName("price")
    val price: Double? = null,
    @SerialName("volume_24h")
    val volume24h: Double? = null
)