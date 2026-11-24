package com.example.khaperskiyteam

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform