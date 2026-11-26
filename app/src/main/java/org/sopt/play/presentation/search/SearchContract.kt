package org.sopt.play.presentation.search

import org.sopt.play.core.base.BaseUiState
import org.sopt.play.domain.model.PostModel

data class SearchUiState(
    val postList: List<PostModel> = emptyList(),
    val nextCursor: Long = 0L,
    val hasNext: Boolean = false,
    val isLoading: Boolean = false,
) : BaseUiState

sealed interface SearchUiEffect
