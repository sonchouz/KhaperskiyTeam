package com.example.khaperskiyteam.data.repository

import com.example.khaperskiyteam.data.supabase.SupabaseProvider
import io.github.jan.supabase.postgrest.postgrest

class AthleteRepository {

    private val client = SupabaseProvider.client

    suspend fun getAthletes():
            Result<List<PublicAthleteDto>> = runCatching {

        client.postgrest
            .rpc("get_public_athletes")
            .decodeList<PublicAthleteDto>()
    }
}