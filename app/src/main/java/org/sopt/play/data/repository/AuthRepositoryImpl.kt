package org.sopt.play.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.sopt.play.R
import org.sopt.play.data.local.datastore.AuthDataStore
import org.sopt.play.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authDataStore: AuthDataStore,
) : AuthRepository {

    override suspend fun register(
        name: String,
        email: String,
        password: String,
    ): Result<Unit> = runCatching {
        authDataStore.saveUser(email, password)
    }

    override suspend fun login(
        email: String,
        password: String,
    ): Result<Unit> = runCatching {
        val savedEmail = authDataStore.email.first()
        val savedPassword = authDataStore.password.first()

        check(
            email == savedEmail
                    && password == savedPassword
        ) { R.string.wrong_input }

        authDataStore.setLoggedIn(true)
    }

    override fun getIsLoggedIn(): Flow<Boolean> = authDataStore.isLoggedIn

    override suspend fun logout(): Result<Unit> = runCatching { authDataStore.setLoggedIn(false) }
}
