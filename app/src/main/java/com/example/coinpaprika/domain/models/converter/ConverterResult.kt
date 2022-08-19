package com.example.coinpaprika.domain.models.converter


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConverterResult(
    @SerialName("amount")
    val amount: Int? = null,
    @SerialName("base_currency_id")
    val baseCurrencyId: String? = null,
    @SerialName("base_currency_name")
    val baseCurrencyName: String? = null,
    @SerialName("base_price_last_updated")
    val basePriceLastUpdated: String? = null,
    @SerialName("price")
    val price: Double? = null,
    @SerialName("quote_currency_id")
    val quoteCurrencyId: String? = null,
    @SerialName("quote_currency_name")
    val quoteCurrencyName: String? = null,
    @SerialName("quote_price_last_updated")
    val quotePriceLastUpdated: String? = null
)