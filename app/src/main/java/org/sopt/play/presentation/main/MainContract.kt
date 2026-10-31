package org.sopt.play.presentation.main

import org.sopt.play.core.base.BaseUiState

enum class StartDestination {
    AUTH, MAIN,
}

data class MainUiState(
    val startDestination: StartDestination? = StartDestination.AUTH,
) : BaseUiState
