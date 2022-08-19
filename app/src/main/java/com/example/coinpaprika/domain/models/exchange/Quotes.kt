package com.example.coinpaprika.domain.models.exchange


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quotes(
    @SerialName("key")
    val kEY: KEY? = null
)