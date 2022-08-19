package com.example.coinpaprika.domain.models.coin_list


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinListItem(
    @SerialName("id")
    val id: String? = null,
    @SerialName("is_active")
    val isActive: Boolean? = null,
    @SerialName("is_new")
    val isNew: Boolean? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("rank")
    val rank: Int? = null,
    @SerialName("symbol")
    val symbol: String? = null,
    @SerialName("type")
    val type: String? = null
)


fun List<CoinListItem>.toDao() : List<com.example.coinpaprika.db.CoinListItem>{
    return map {
        it.toDao()
    }
}

fun List<com.example.coinpaprika.db.CoinListItem>.toDomain() : List<CoinListItem>{
    return map {
        it.toDomain()
    }
}

fun CoinListItem.toDao() : com.example.coinpaprika.db.CoinListItem {
    return com.example.coinpaprika.db.CoinListItem(
        id = id ?:"",
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank?.toLong(),
        symbol = symbol,
        type = type
    )
}

fun com.example.coinpaprika.db.CoinListItem.toDomain() : CoinListItem {
    return CoinListItem(
        id = id,
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank?.toInt(),
        symbol = symbol,
        type = type
    )
}