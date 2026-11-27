package org.sopt.play.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.domain.model.PostModel
import org.sopt.play.domain.model.postDummy

@Composable
fun PostSection(
    postList: List<PostModel>,
    onPostClick: (Long) -> Unit,
    onPostLongClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (postList.isEmpty()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "검색 결과가 없습니다.",
                style = PLAYSOPTTheme.typography.body.m18,
                color = PLAYSOPTTheme.colors.gray3,
            )
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(items = postList, key = { it.postId }) { post ->
                PostCard(
                    postId = post.postId,
                    authorName = post.author,
                    createdAt = post.createdAt,
                    title = post.title,
                    content = post.content,
                    onClick = { onPostClick(post.postId) },
                    onLongClick = { onPostLongClick(post.postId) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun PostSectionPreview() {
    PlaySoptTheme {
        PostSection(
            postList = postDummy,
            onPostClick = {},
            onPostLongClick = {},
        )
    }
}

@Preview
@Composable
private fun PostSectionPreviewEmpty() {
    PlaySoptTheme {
        PostSection(
            postList = emptyList(),
            onPostClick = {},
            onPostLongClick = {},
        )
    }
}