package org.sopt.play.presentation.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.domain.repository.AuthRepository

class MainViewModel(
    private val authRepository: AuthRepository,
) :
    BaseViewModel<MainUiState, Unit>(
        initialState = MainUiState,
    ) {
    private val _startDestination = MutableStateFlow<StartDestination?>(null)
    val startDestination = _startDestination.asStateFlow()

    init {
        viewModelScope.launch {
            val isLoggedIn = authRepository.isLoggedIn.first()
            _startDestination.value =
                if (isLoggedIn) StartDestination.MAIN
                else StartDestination.AUTH
        }
    }
}
