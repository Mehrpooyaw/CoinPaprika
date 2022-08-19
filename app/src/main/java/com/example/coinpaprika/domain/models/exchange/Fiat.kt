package com.example.coinpaprika.domain.models.exchange


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fiat(
    @SerialName("name")
    val name: String? = null,
    @SerialName("symbol")
    val symbol: String? = null
)