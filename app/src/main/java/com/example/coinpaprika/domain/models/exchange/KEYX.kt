package com.example.coinpaprika.domain.models.exchange


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KEYX(
    @SerialName("adjusted_volume_24h")
    val adjustedVolume24h: Int? = null,
    @SerialName("adjusted_volume_30d")
    val adjustedVolume30d: Int? = null,
    @SerialName("adjusted_volume_7d")
    val adjustedVolume7d: Int? = null,
    @SerialName("reported_volume_24h")
    val reportedVolume24h: Int? = null,
    @SerialName("reported_volume_30d")
    val reportedVolume30d: Int? = null,
    @SerialName("reported_volume_7d")
    val reportedVolume7d: Int? = null
)