package org.sopt.play.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.play.presentation.search.SearchViewModel

class ViewModelFactory(
    private val container: AppContainer,
    private val postId: Long = 0L,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(SearchViewModel::class.java) ->
                SearchViewModel(container.searchRepository) as T

            else -> throw IllegalArgumentException(
                "Unknown ViewModel class: ${modelClass.name}",
            )
        }
}
