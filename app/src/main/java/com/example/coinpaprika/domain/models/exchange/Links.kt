package com.example.coinpaprika.domain.models.exchange


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("twitter")
    val twitter: List<String?>? = null,
    @SerialName("website")
    val website: List<String?>? = null
)