package org.sopt.play.presentation.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.common.extension.toDateString
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun PostCard(
    authorName: String,
    createdAt: Long,
    title: String,
    content: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = PLAYSOPTTheme.colors.gray1)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        UserRow(
            authorName = authorName,
            createdAt = createdAt,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = title,
                style = PLAYSOPTTheme.typography.body.m16,
                color = PLAYSOPTTheme.colors.gray5,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = content,
                style = PLAYSOPTTheme.typography.caption.m14,
                color = PLAYSOPTTheme.colors.gray5,
            )
        }
    }
}

@Composable
private fun UserRow(
    authorName: String,
    createdAt: Long,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = authorName,
            style = PLAYSOPTTheme.typography.caption.m12,
            color = PLAYSOPTTheme.colors.gray3,
            modifier = Modifier.weight(1f, fill = false),
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
        )

        VerticalDivider(
            thickness = 1.dp,
            color = PLAYSOPTTheme.colors.gray3,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 1.dp),
        )

        Text(
            text = createdAt.toDateString(),
            style = PLAYSOPTTheme.typography.caption.m12,
            color = PLAYSOPTTheme.colors.gray3,
            softWrap = false,
        )
    }
}

@Preview
@Composable
private fun PostCardPreview() {
    PlaySoptTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            PostCard(
                authorName = "작성자",
                createdAt = 0L,
                title = "제목",
                content = "본문입니다."
            )

            PostCard(
                authorName = "작성자이름은김예림입니다안녕하세요반가워요지금시간은3시40분이네요",
                createdAt = 0L,
                title = "제목도 길어지면 이렇게 됩니다 제목은 한 줄만 보여줍니다",
                content = "언더테일 아시는구나! 혹시 모르시는분들에 대해 설명해드립니다 샌즈랑 언더테일의 세가지 엔딩루트중 몰살엔딩의 최종보스로 진.짜.겁.나.어.렵.습.니.다 공격은 전부다 회피하고 만피가 92인데 샌즈의 공격은 1초당 60이 다는데다가 독뎀까지 추가로 붙어있습니다.. 하지만 이러면 절대로 게임을 깰 수 가없으니 제작진이 치명적인 약점을 만들었죠. 샌즈의 치명적인 약점이 바로 지친다는것입니다. 패턴들을 다 견디고나면 지쳐서 자신의 턴을 유지한채로 잠에듭니다. 하지만 잠이들었을때 창을옮겨서 공격을 시도하고 샌즈는 1차공격은 피하지만 그 후에 바로날아오는 2차 공격을 맞고 죽습니다."
            )
        }
    }
}
