package org.sopt.play.presentation.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.common.extension.noRippleClickable
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun FloatingButton(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_plus_28),
        contentDescription = "게시글 작성",
        tint = PLAYSOPTTheme.colors.white,
        modifier = modifier
            .size(60.dp)
            .dropShadow(
                shape = CircleShape,
                shadow = Shadow(
                    radius = 12.dp,
                    color = PLAYSOPTTheme.colors.black,
                    alpha = 0.15f,
                    offset = DpOffset(x = 0.dp, y = 4.dp),
                ),
            )
            .clip(CircleShape)
            .background(PLAYSOPTTheme.colors.red)
            .noRippleClickable(onButtonClick)
            .padding(16.dp)
            .semantics { role = Role.Button }
    )
}

@Preview(showBackground = true)
@Composable
private fun FloatingButtonPreview() {
    PlaySoptTheme {
        FloatingButton(
            modifier = Modifier.padding(10.dp),
            onButtonClick = {},
        )
    }
}
