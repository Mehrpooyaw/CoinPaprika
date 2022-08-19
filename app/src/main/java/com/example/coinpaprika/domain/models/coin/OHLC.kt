package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OHLC(
    @SerialName("allowance")
    val allowance: com.example.coinpaprika.domain.models.coin.Allowance? = null,
    @SerialName("result")
    val result: com.example.coinpaprika.domain.models.coin.Result? = null
)