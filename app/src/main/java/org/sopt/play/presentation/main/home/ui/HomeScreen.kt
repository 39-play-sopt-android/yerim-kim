package org.sopt.play.presentation.main.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun HomeRoute(
    modifier: Modifier,
) {
    HomeScreen(
        modifier = modifier,
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ){
        Text("홈입니다~")
    }
}

@Preview
@Composable
private fun HomeScreenPreview(){
    PlaySoptTheme {
        HomeScreen()
    }
}
