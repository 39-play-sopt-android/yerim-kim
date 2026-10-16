package org.sopt.play.presentation.main.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

val bannerImageList = listOf(
    R.drawable.img_banner1,
    R.drawable.img_banner1,
    R.drawable.img_banner1,
)

@Composable
fun MainBanner(
    modifier: Modifier = Modifier,
) {
    val pageCount = Int.MAX_VALUE

    val pagerState = rememberPagerState(
        initialPage = pageCount / 2,
        pageCount = { pageCount },
    )

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        pageSpacing = 6.dp,
    ) { page ->
        Image(
            painter = painterResource(bannerImageList[page % bannerImageList.size]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(291f / 173f),
        )
    }
}

@Preview
@Composable
private fun MainBannerPreview() {
    PlaySoptTheme {
        MainBanner()
    }
}
