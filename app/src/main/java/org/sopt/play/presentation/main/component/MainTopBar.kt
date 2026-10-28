package org.sopt.play.presentation.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.noRippleClickable

@Composable
fun MainTopBar(
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(PLAYSOPTTheme.colors.white)
            .padding(start = 16.dp, end = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HomeTitle(
            text = stringResource(R.string.home_title),
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_search_24),
            contentDescription = "검색",
            modifier = Modifier
                .noRippleClickable(onSearchClick)
                .padding(10.dp),
        )
    }
}

@Composable
private fun HomeTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current

    CompositionLocalProvider(
        LocalDensity provides Density(density.density, fontScale = 1f),
    ) {
        Text(
            text =  text,
            modifier = modifier,
            style = PLAYSOPTTheme.typography.headline.b28,
            color = PLAYSOPTTheme.colors.black,
        )
    }
}

@Preview
@Composable
private fun MainTopBarPreview() {
    PlaySoptTheme {
        MainTopBar(
            onSearchClick = {},
        )
    }
}
