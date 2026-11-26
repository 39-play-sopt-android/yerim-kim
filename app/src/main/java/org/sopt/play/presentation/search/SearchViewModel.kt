package org.sopt.play.presentation.search

import androidx.compose.foundation.text.input.TextFieldState
import org.sopt.play.core.base.BaseViewModel

class SearchViewModel :
    BaseViewModel<SearchUiState, SearchUiEffect>(
        initialState = SearchUiState.dummy, // TODO : 빈 값으로 복원
    ) {
    val searchState = TextFieldState()
    val titleState = TextFieldState()
    val contentState = TextFieldState()
    fun onSearchClick() {

    }
}
