package com.example.khaperskiyteam.data.model

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val date: String,
    val location: String,
    val description: String
)

data class Athlete(
    val id: Int,
    val fullName: String,
    val age: Int,
    val belt: String,
    val medals: Int
)