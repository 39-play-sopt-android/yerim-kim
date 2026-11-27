package org.sopt.play.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.play.presentation.auth.login.LoginViewModel
import org.sopt.play.presentation.auth.register.RegisterViewModel
import org.sopt.play.presentation.home.HomeViewModel
import org.sopt.play.presentation.main.MainViewModel
import org.sopt.play.presentation.search.SearchViewModel

class ViewModelFactory(
    private val container: AppContainer,
    private val postId: Long = 0L,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(container.authRepository) as T

            modelClass.isAssignableFrom(RegisterViewModel::class.java) ->
                RegisterViewModel(container.authRepository) as T

            modelClass.isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(container.authRepository) as T

            modelClass.isAssignableFrom(SearchViewModel::class.java) ->
                SearchViewModel(container.searchRepository, container.authRepository) as T

            modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(container.authRepository) as T

            else -> throw IllegalArgumentException(
                "Unknown ViewModel class: ${modelClass.name}",
            )
        }
}
