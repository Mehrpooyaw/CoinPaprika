package com.example.coinpaprika.domain.models.global


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Global(
    @SerialName("bitcoin_dominance_percentage")
    val bitcoinDominancePercentage: Double? = null,
    @SerialName("cryptocurrencies_number")
    val cryptocurrenciesNumber: Int? = null,
    @SerialName("last_updated")
    val lastUpdated: Int? = null,
    @SerialName("market_cap_ath_date")
    val marketCapAthDate: String? = null,
    @SerialName("market_cap_ath_value")
    val marketCapAthValue: Long? = null,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Double? = null,
    @SerialName("market_cap_usd")
    val marketCapUsd: Long? = null,
    @SerialName("volume_24h_ath_date")
    val volume24hAthDate: String? = null,
    @SerialName("volume_24h_ath_value")
    val volume24hAthValue: Long? = null,
    @SerialName("volume_24h_change_24h")
    val volume24hChange24h: Double? = null,
    @SerialName("volume_24h_usd")
    val volume24hUsd: Long? = null
)