package org.sopt.play.di

import android.content.Context
import org.sopt.play.core.network.NetworkModule
import org.sopt.play.data.local.datastore.AuthDataStore
import org.sopt.play.data.remote.AuthService
import org.sopt.play.data.remote.SearchService
import org.sopt.play.data.repository.AuthRepositoryImpl
import org.sopt.play.data.repository.SearchRepositoryImpl
import org.sopt.play.domain.repository.AuthRepository
import org.sopt.play.domain.repository.SearchRepository

class AppContainer(context: Context) {
    private val appContext = context.applicationContext
    private val authDataStore by lazy { AuthDataStore(appContext) }

    private val authService by lazy { NetworkModule.createService<AuthService>() }
    val authRepository: AuthRepository by lazy { AuthRepositoryImpl(authDataStore, authService) }

    private val searchService by lazy { NetworkModule.createService<SearchService>() }
    val searchRepository: SearchRepository by lazy { SearchRepositoryImpl(searchService) }
}
