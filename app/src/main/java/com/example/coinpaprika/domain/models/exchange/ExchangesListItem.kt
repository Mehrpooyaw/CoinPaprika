package com.example.coinpaprika.domain.models.exchange


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangesListItem(
    @SerialName("active")
    val active: Boolean? = null,
    @SerialName("adjusted_rank")
    val adjustedRank: Int? = null,
    @SerialName("api_status")
    val apiStatus: Boolean? = null,
    @SerialName("currencies")
    val currencies: Int? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("fiats")
    val fiats: List<Fiat?>? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("last_updated")
    val lastUpdated: String? = null,
    @SerialName("links")
    val links: Links? = null,
    @SerialName("markets")
    val markets: Int? = null,
    @SerialName("markets_data_fetched")
    val marketsDataFetched: Boolean? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("quotes")
    val quotes: Quotes? = null,
    @SerialName("reported_rank")
    val reportedRank: Int? = null,
    @SerialName("website_status")
    val websiteStatus: Boolean? = null
)