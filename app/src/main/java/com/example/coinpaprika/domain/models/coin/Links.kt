package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.Polymorphic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("explorer")
    val explorer: List<String?>? = null,
    @SerialName("facebook")
    val facebook: List<String?>? = null,
    @SerialName("reddit")
    val reddit: List<String?>? = null,
    @SerialName("source_code")
    val sourceCode: List<String?>? = null,
    @SerialName("website")
    val website: List<String?>? = null,
    @SerialName("youtube")
    val youtube: List<String?>? = null
)