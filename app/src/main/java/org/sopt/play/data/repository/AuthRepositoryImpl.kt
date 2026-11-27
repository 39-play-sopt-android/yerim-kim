package org.sopt.play.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import org.sopt.play.core.common.util.suspendRunCatching
import org.sopt.play.data.local.datastore.AuthDataStore
import org.sopt.play.domain.model.UserModel
import org.sopt.play.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authDataStore: AuthDataStore,
) : AuthRepository {
    override suspend fun register(
        name: String,
        email: String,
        password: String,
    ): Result<Unit> = suspendRunCatching {
        authDataStore.saveUser(name, email, password)
    }

    override val currentUser: Flow<UserModel?>
        get() = authDataStore.userProfile

    override suspend fun login(
        email: String,
        password: String,
    ): Result<Unit> {
        val savedUser = authDataStore.userProfile.first()
        val savedPassword = authDataStore.password.first()

        if (email != savedUser?.email || password != savedPassword) {
            return Result.failure(Exception())
        }

        return suspendRunCatching { authDataStore.setLoggedIn(true) }
    }

    override val isLoggedIn: Flow<Boolean> get() = authDataStore.isLoggedIn

    override suspend fun logout(): Result<Unit> =
        suspendRunCatching { authDataStore.setLoggedIn(false) }
}
