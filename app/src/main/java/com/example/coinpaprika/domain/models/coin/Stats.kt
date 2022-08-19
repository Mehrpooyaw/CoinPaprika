package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    @SerialName("contributors")
    val contributors: Int? = null,
    @SerialName("stars")
    val stars: Int? = null,
    @SerialName("subscribers")
    val subscribers: Int? = null
)