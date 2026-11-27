package org.sopt.play.presentation.search

import org.sopt.play.core.base.BaseUiState
import org.sopt.play.domain.model.PostModel
import org.sopt.play.domain.model.postDummy

data class SearchUiState(
    val postList: List<PostModel> = emptyList(),
    val nextCursor: Long? = null,
    val hasNext: Boolean = false,
    val isLoading: Boolean = false,
    val showBottomSheet: Boolean = false,
    val selectedPostId: Long? = null,
    val showModal: Boolean = false,
) : BaseUiState {
    companion object {
        val dummy = SearchUiState(
            postList = postDummy,
            nextCursor = 1L,
            hasNext = true,
        )
    }
}

sealed interface SearchUiEffect
