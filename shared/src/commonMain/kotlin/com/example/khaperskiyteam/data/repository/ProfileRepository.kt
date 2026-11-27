package com.example.khaperskiyteam.data.repository

import com.example.khaperskiyteam.data.supabase.SupabaseProvider
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.from

class ProfileRepository {

    private val client = SupabaseProvider.client

    suspend fun getProfile(): Result<UserDto> =
        runCatching {

            val userId = client.auth
                .currentUserOrNull()?.id
                ?: error("Пользователь не авторизован")

            client.from("users")
                .select {
                    filter {
                        eq("id", userId)
                    }
                }
                .decodeSingle<UserDto>()
        }

    suspend fun getRole(
        roleId: Int
    ): Result<RoleDto> = runCatching {

        client.from("roles")
            .select {
                filter {
                    eq("id", roleId)
                }
            }
            .decodeSingle<RoleDto>()
    }

    suspend fun getBelt(
        beltId: Int
    ): Result<BeltDto> = runCatching {

        client.from("belts")
            .select {
                filter {
                    eq("id", beltId)
                }
            }
            .decodeSingle<BeltDto>()
    }

    suspend fun setPublicProfile(
        enabled: Boolean
    ): Result<Unit> = runCatching {

        val userId = client.auth
            .currentUserOrNull()?.id
            ?: error("Пользователь не авторизован")

        client.from("users")
            .update({
                set("public_profile", enabled)
            }) {
                filter {
                    eq("id", userId)
                }
            }

        Unit
    }
}