package com.example.khaperskiyteam.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PublicAthleteDto(
    val id: String,

    @SerialName("full_name")
    val fullName: String,

    @SerialName("belt_name")
    val beltName: String,

    @SerialName("medals_count")
    val medalsCount: Long,

    @SerialName("photo_url")
    val photoUrl: String? = null
)