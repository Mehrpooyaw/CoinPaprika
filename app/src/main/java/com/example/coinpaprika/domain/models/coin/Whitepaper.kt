package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Whitepaper(
    @SerialName("link")
    val link: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null
)