package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coin(
    @SerialName("contract")
    val contract: String? = null,
    @SerialName("contracts")
    val contracts: List<Contract?>? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("development_status")
    val developmentStatus: String? = null,
    @SerialName("first_data_at")
    val firstDataAt: String? = null,
    @SerialName("hardware_wallet")
    val hardwareWallet: Boolean? = null,
    @SerialName("hash_algorithm")
    val hashAlgorithm: String? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("is_active")
    val isActive: Boolean? = null,
    @SerialName("is_new")
    val isNew: Boolean? = null,
    @SerialName("last_data_at")
    val lastDataAt: String? = null,
    @SerialName("links")
    val links: Links? = null,
    @SerialName("links_extended")
    val linksExtended: List<LinksExtended?>? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("open_source")
    val openSource: Boolean? = null,
    @SerialName("org_structure")
    val orgStructure: String? = null,
    @SerialName("parent")
    val parent: Parent? = null,
    @SerialName("platform")
    val platform: String? = null,
    @SerialName("proof_type")
    val proofType: String? = null,
    @SerialName("rank")
    val rank: Int? = null,
    @SerialName("started_at")
    val startedAt: String? = null,
    @SerialName("symbol")
    val symbol: String? = null,
    @SerialName("tags")
    val tags: List<Tag?>? = null,
    @SerialName("team")
    val team: List<Team?>? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("whitepaper")
    val whitepaper: Whitepaper? = null,

    val isFavorite : Boolean = false
)