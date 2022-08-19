package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("604800_Monday")
    val monday: List<List<Double?>?>? = null,
    @SerialName("14400")
    val x14400: List<List<Double?>?>? = null,
    @SerialName("180")
    val x180: List<List<Double?>?>? = null,
    @SerialName("1800")
    val x1800: List<List<Double?>?>? = null,
    @SerialName("21600")
    val x21600: List<List<Double?>?>? = null,
    @SerialName("259200")
    val x259200: List<List<Double?>?>? = null,
    @SerialName("300")
    val x300: List<List<Double?>?>? = null,
    @SerialName("3600")
    val x3600: List<List<Double?>?>? = null,
    @SerialName("43200")
    val x43200: List<List<Double?>?>? = null,
    @SerialName("60")
    val x60: List<List<Double?>?>? = null,
    @SerialName("604800")
    val x604800: List<List<Double?>?>? = null,
    @SerialName("7200")
    val x7200: List<List<Double?>?>? = null,
    @SerialName("86400")
    val x86400: List<List<Double?>?>? = null,
    @SerialName("900")
    val x900: List<List<Double?>?>? = null
)