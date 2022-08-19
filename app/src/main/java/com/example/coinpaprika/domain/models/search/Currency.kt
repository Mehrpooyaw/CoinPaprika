package com.example.coinpaprika.domain.models.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Currency(
    @SerialName("id")
    val id: String? = null,
    @SerialName("is_active")
    val isActive: Boolean? = null,
    @SerialName("is_new")
    val isNew: Boolean? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("rank")
    val rank: Int? = null,
    @SerialName("symbol")
    val symbol: String? = null,
    @SerialName("type")
    val type: String? = null
)