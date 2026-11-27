package com.example.khaperskiyteam.data.model

data class Training(
    val id: Int,
    val title: String,
    val group: String,
    val date: String,
    val time: String,
    val coach: String,
    val availablePlaces: Int,
    val totalPlaces: Int
)

data class TrainingGroup(
    val id: Int,
    val name: String,
    val coach: String,
    val age: String,
    val schedule: String,
    val availablePlaces: Int,
    val totalPlaces: Int
)