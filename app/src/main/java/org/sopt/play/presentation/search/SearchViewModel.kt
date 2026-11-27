package org.sopt.play.presentation.search

import android.util.Log
import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.domain.repository.AuthRepository
import org.sopt.play.domain.repository.SearchRepository

class SearchViewModel(
    private val searchRepository: SearchRepository,
    private val authRepository: AuthRepository,
) : BaseViewModel<SearchUiState, SearchUiEffect>(
    initialState = SearchUiState(),
) {
    val searchState = TextFieldState()
    val titleState = TextFieldState()
    val contentState = TextFieldState()

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

    fun onCompleteClick() {
        val title = titleState.text.toString().trim()
        val content = titleState.text.toString().trim()

        viewModelScope.launch {
            updateState { copy(showBottomSheet = false) }

            val author = authRepository.currentUser.first()?.name

            searchRepository.createPost(
                authorizationCode = "20030207", // TODO : 인증 코드 발급 API 연동
                title = title,
                content = content,
                author = author.toString(),
            ).onSuccess {
                updateState {
                    copy(
                        isLoading = false,
                    )
                }
                loadPosts()
            }.onFailure { throwable ->
                Log.e("ServiceViewModel", "게시글 작성 실패", throwable)
                updateState { copy(isLoading = false) }
            }
        }
    }

    fun onFloatingClick() {
        updateState { copy(showBottomSheet = true) }
    }

    fun onBottomSheetDismiss() {
        updateState { copy(showBottomSheet = false) }
    }
}
