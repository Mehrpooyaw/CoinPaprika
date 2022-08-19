package com.example.coinpaprika.domain.models.coin


import com.example.coinpaprika.domain.models.coin.KEY
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quotes(
    @SerialName("USD")
    val kEY: KEY? = null
)