package com.example.khaperskiyteam.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BeltDto(
    val id: Int,
    val code: String,
    val name: String,

    @SerialName("sort_order")
    val sortOrder: Int
)