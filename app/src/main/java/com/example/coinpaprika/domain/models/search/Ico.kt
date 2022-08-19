package com.example.coinpaprika.domain.models.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ico(
    @SerialName("id")
    val id: String? = null,
    @SerialName("is_new")
    val isNew: Boolean? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("symbol")
    val symbol: String? = null
)