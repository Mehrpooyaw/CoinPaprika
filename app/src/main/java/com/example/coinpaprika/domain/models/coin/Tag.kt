package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("coin_counter")
    val coinCounter: Int? = null,
    @SerialName("ico_counter")
    val icoCounter: Int? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null
)