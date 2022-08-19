package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contract(
    @SerialName("contract")
    val contract: String? = null,
    @SerialName("platform")
    val platform: String? = null,
    @SerialName("type")
    val type: String? = null
)