package com.example.khaperskiyteam.data.repository

import com.example.khaperskiyteam.data.supabase.SupabaseProvider
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class AuthRepository {

    private val auth = SupabaseProvider.client.auth

    suspend fun signUp(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        middleName: String,
        birthDate: String,
        phone: String
    ): Result<Unit> = runCatching {

        auth.signUpWith(Email) {

            this.email = email.trim().lowercase()
            this.password = password

            data = buildJsonObject {

                put("first_name", firstName.trim())
                put("last_name", lastName.trim())
                put("phone", phone.trim())

                if (middleName.isNotBlank()) {
                    put("middle_name", middleName.trim())
                }

                if (birthDate.isNotBlank()) {
                    put("birth_date", birthDate)
                }
            }
        }

        Unit
    }

    suspend fun signIn(
        email: String,
        password: String
    ): Result<Unit> = runCatching {

        auth.signInWith(Email) {
            this.email = email.trim().lowercase()
            this.password = password
        }

        Unit
    }

    suspend fun signOut(): Result<Unit> =
        runCatching {
            auth.signOut()
        }

    suspend fun awaitInitialization() {
        auth.awaitInitialization()
    }

    fun isAuthenticated(): Boolean {
        return auth.currentSessionOrNull() != null
    }

    fun getCurrentUserId(): String? {
        return auth.currentUserOrNull()?.id
    }

    fun getCurrentEmail(): String? {
        return auth.currentUserOrNull()?.email
    }
}