package com.example.coinpaprika.domain.models.exchange


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuotesX(
    @SerialName("key")
    val kEY: KEYX? = KEYX()
)