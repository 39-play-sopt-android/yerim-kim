package org.sopt.play.presentation.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.data.di.RepositoryModule.authRepository

class MainViewModel ():
    BaseViewModel<MainUiState, Unit>(
        initialState = MainUiState(),
    ) {
    private val _startDestination = MutableStateFlow<StartDestination?>(null)
    val startDestination = _startDestination.asStateFlow()

    init {
        viewModelScope.launch {
            val isLoggedIn = authRepository.getIsLoggedIn().first()
            _startDestination.value =
                if (isLoggedIn) StartDestination.MAIN
                else StartDestination.AUTH
        }
    }
}
