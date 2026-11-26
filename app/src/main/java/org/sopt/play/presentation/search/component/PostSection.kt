package org.sopt.play.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
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
    }
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items (postList.size) {
            PostCard(
                authorName = postList[it].author,
                createdAt = postList[it].createdAt,
                title = postList[it].title,
                content = postList[it].content,
            )
        }
    }
}

@Preview
@Composable
private fun PostSectionPreview(){
    PlaySoptTheme{
        PostSection(
            postList = postDummy,
        )
    }
}

@Preview
@Composable
private fun PostSectionPreviewEmpty(){
    PlaySoptTheme{
        PostSection(
            postList = emptyList(),
        )
    }
}