package com.example.khaperskiyteam.data.model

data class Membership(
    val id: Int,
    val name: String,
    val sessions: Int,
    val price: Int,
    val duration: String,
    val description: String
)