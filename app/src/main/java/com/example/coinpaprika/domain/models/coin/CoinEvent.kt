package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinEvent(
    @SerialName("date")
    val date: String? = null,
    @SerialName("date_to")
    val dateTo: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("is_conference")
    val isConference: Boolean? = null,
    @SerialName("link")
    val link: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("proof_image_link")
    val proofImageLink: String? = null
)