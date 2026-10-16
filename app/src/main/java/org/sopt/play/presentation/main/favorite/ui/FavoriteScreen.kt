package org.sopt.play.presentation.main.favorite.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun FavoriteRoute(
    modifier: Modifier = Modifier,
) {
    FavoriteScreen()
}

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PLAYSOPTTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "찜~",
            modifier = Modifier,
            style = PLAYSOPTTheme.typography.body.m18,
        )
    }
}

@Preview
@Composable
private fun FavoriteScreenPreview() {
    PlaySoptTheme {
        FavoriteScreen()
    }
}
