package com.example.coinpaprika.domain.models.exchange


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Exchange(
    @SerialName("active")
    val active: Boolean? = false,
    @SerialName("adjusted_rank")
    val adjustedRank: Int? = 0,
    @SerialName("api_status")
    val apiStatus: Boolean? = false,
    @SerialName("currencies")
    val currencies: Int? = 0,
    @SerialName("description")
    val description: String? = "",
    @SerialName("fiats")
    val fiats: List<FiatX>? = listOf(),
    @SerialName("id")
    val id: String? = "",
    @SerialName("last_updated")
    val lastUpdated: String? = "",
    @SerialName("links")
    val links: LinksX? = LinksX(),
    @SerialName("markets")
    val markets: Int? = 0,
    @SerialName("markets_data_fetched")
    val marketsDataFetched: Boolean? = false,
    @SerialName("message")
    val message: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("quotes")
    val quotes: QuotesX? = QuotesX(),
    @SerialName("reported_rank")
    val reportedRank: Int? = 0,
    @SerialName("website_status")
    val websiteStatus: Boolean? = false
)