package org.sopt.play.di

import org.sopt.play.core.network.NetworkModule
import org.sopt.play.data.remote.SearchService
import org.sopt.play.data.repository.SearchRepositoryImpl
import org.sopt.play.domain.repository.SearchRepository

class AppContainer {
    private val searchService by lazy { NetworkModule.createService<SearchService>() }
    val searchRepository: SearchRepository by lazy { SearchRepositoryImpl(searchService) }
}
