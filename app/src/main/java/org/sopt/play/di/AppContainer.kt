package org.sopt.play.di

import android.content.Context
import org.sopt.play.core.network.NetworkModule
import org.sopt.play.data.local.datastore.AuthDataStore
import org.sopt.play.data.remote.SearchService
import org.sopt.play.data.repository.AuthRepositoryImpl
import org.sopt.play.data.repository.SearchRepositoryImpl

class AppContainer(context: Context) {
    private val appContext = context.applicationContext
    private val authDataStore: AuthDataStore by lazy {
        AuthDataStore(appContext)
    }
    val authRepository by lazy { AuthRepositoryImpl(authDataStore) }

    private val searchService by lazy { NetworkModule.createService<SearchService>() }
    val searchRepository by lazy { SearchRepositoryImpl(searchService) }
}
