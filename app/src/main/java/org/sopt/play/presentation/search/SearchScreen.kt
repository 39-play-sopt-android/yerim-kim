package org.sopt.play.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.domain.model.PostModel
import org.sopt.play.domain.model.postDummy
import org.sopt.play.presentation.search.component.FloatingButton
import org.sopt.play.presentation.search.component.PostSection
import org.sopt.play.presentation.search.component.SearchTextField

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
) {
    SearchScreen(
        searchState = TextFieldState(),
        onSearchClick = {},
        postList = emptyList(),
        modifier = modifier,
    )
}

@Composable
fun SearchScreen(
    searchState: TextFieldState,
    onSearchClick: () -> Unit,
    postList: List<PostModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PLAYSOPTTheme.colors.white)
            .padding(horizontal = 16.dp),
    ) {
        SearchTextField(
            state = searchState,
            placeholder = "검색어를 입력하세요",
            onSearchClick = onSearchClick,
            modifier = Modifier.padding(vertical = 12.dp),
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {

            PostSection(
                postList = postList,
            )

            FloatingButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 20.dp),
                onButtonClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    PlaySoptTheme {
        SearchScreen(
            searchState = TextFieldState(),
            onSearchClick = {},
            postList = postDummy,
        )
    }
}
