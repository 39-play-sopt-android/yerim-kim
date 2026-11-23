package org.sopt.play.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import org.sopt.play.core.common.util.suspendRunCatching
import org.sopt.play.data.local.datastore.AuthDataStore
import org.sopt.play.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authDataStore: AuthDataStore,
) : AuthRepository {

    override suspend fun register(
        name: String,
        email: String,
        password: String,
    ): Result<Unit> = suspendRunCatching {
        authDataStore.saveUser(email, password)
    }

    override suspend fun login(
        email: String,
        password: String,
    ): Result<Unit> {
        val savedEmail = authDataStore.email.first()
        val savedPassword = authDataStore.password.first()

        if (email != savedEmail || password != savedPassword) {
            return Result.failure(Exception())
        }

        return suspendRunCatching { authDataStore.setLoggedIn(true) }
    }

    override fun getIsLoggedIn(): Flow<Boolean> = authDataStore.isLoggedIn

    override suspend fun logout(): Result<Unit> =
        suspendRunCatching { authDataStore.setLoggedIn(false) }
}
