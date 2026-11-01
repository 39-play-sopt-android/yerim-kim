package org.sopt.play.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun register(name: String, email: String, password: String): Result<Unit>

    suspend fun login(email: String, password: String): Result<Unit>

    suspend fun logout(): Result<Unit>

    fun getIsLoggedIn(): Flow<Boolean>
}
