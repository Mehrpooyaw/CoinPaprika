package com.example.coinpaprika.domain.models.coin


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinTwitter(
    @SerialName("date")
    val date: String? = null,
    @SerialName("is_retweet")
    val isRetweet: Boolean? = null,
    @SerialName("like_count")
    val likeCount: Int? = null,
    @SerialName("media_link")
    val mediaLink: String? = null,
    @SerialName("retweet_count")
    val retweetCount: Int? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("status_id")
    val statusId: String? = null,
    @SerialName("status_link")
    val statusLink: String? = null,
    @SerialName("user_image_link")
    val userImageLink: String? = null,
    @SerialName("user_name")
    val userName: String? = null,
    @SerialName("youtube_link")
    val youtubeLink: String? = null
)