package org.sopt.play.presentation.main.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.noRippleClickable

@Composable
fun MainTopBar(
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(
            text = "PLAY SOPT",
            style = PLAYSOPTTheme.typography.headline.b28,
            color = PLAYSOPTTheme.colors.black,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(R.drawable.ic_search_24),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .noRippleClickable(onSearchClick),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainTopBarPreview(){
    PlaySoptTheme {
        MainTopBar(
            onSearchClick = {},
        )
    }
}
