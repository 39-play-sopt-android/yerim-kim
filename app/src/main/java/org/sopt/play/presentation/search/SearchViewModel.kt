package org.sopt.play.presentation.search

import android.util.Log
import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.domain.repository.SearchRepository

class SearchViewModel(
    private val searchRepository: SearchRepository,
) :
    BaseViewModel<SearchUiState, SearchUiEffect>(
        initialState = SearchUiState(),
    ) {
    val searchState = TextFieldState()

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            updateState { copy(isLoading = true) }

            searchRepository.getPosts()
                .onSuccess {
                    updateState {
                        copy(
                            postList = it.posts,
                            nextCursor = it.nextCursor,
                            hasNext = it.hasNext,
                            isLoading = false,
                        )
                    }
                }
                .onFailure { throwable ->
                    Log.e("ServiceViewModel", "포스트 조회 실패", throwable)
                    updateState { copy(isLoading = false) }
                }
        }
    }

    fun onSearchClick() {

    }

    fun onFloatingClick() {
        updateState { copy(showBottomSheet = true) }
    }

    fun onBottomSheetDismiss() {
        updateState { copy(showBottomSheet = false) }
    }
}
