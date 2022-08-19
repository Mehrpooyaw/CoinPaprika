package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Allowance(
    @SerialName("cost")
    val cost: Double? = null,
    @SerialName("remaining")
    val remaining: Double? = null,
    @SerialName("upgrade")
    val upgrade: String? = null
)