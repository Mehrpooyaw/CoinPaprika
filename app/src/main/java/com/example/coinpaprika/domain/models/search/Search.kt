package com.example.coinpaprika.domain.models.search


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Search(
    @SerialName("currencies")
    val currencies: List<Currency?>? = null,
    @SerialName("exchanges")
    val exchanges: List<Exchange?>? = null,
    @SerialName("icos")
    val icos: List<Ico?>? = null,
    @SerialName("people")
    val people: List<People?>? = null,
    @SerialName("tags")
    val tags: List<Tag?>? = null
)