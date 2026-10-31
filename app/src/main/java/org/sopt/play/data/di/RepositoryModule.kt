package org.sopt.play.data.di

import android.content.Context
import org.sopt.play.data.local.datastore.AuthDataStore
import org.sopt.play.data.repository.AuthRepositoryImpl
import org.sopt.play.domain.repository.AuthRepository

object RepositoryModule {
    private lateinit var authDataStore: AuthDataStore

    fun init(context: Context) {
        authDataStore = AuthDataStore(context.applicationContext)
    }

    val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authDataStore)
    }
}