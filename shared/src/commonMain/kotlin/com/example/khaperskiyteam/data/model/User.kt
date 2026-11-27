package com.example.khaperskiyteam.data.model

enum class UserRole {
    GUEST,
    ATHLETE,
    COACH,
    ADMIN
}

data class User(
    val id: String = "",
    val firstName: String,
    val lastName: String,
    val middleName: String = "",
    val birthDate: String = "",
    val phone: String = "",
    val email: String = "",
    val belt: String = "Белый пояс",
    val group: String = "",
    val role: UserRole = UserRole.ATHLETE
)