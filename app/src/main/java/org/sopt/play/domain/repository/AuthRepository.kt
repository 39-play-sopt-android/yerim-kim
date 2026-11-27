package org.sopt.play.domain.repository

import kotlinx.coroutines.flow.Flow
import org.sopt.play.domain.model.UserModel

interface AuthRepository {
    val isLoggedIn: Flow<Boolean>
    val currentUser: Flow<UserModel?>
    suspend fun register(name: String, email: String, password: String): Result<Unit>

    suspend fun login(email: String, password: String): Result<Unit>

    suspend fun logout(): Result<Unit>

}
