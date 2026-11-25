package org.sopt.play.presentation.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.common.extension.noRippleClickable
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun SearchTextField(
    state: TextFieldState,
    placeholder: String,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }

    BasicTextField(
        state = state,
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(12.dp),
                color = PLAYSOPTTheme.colors.white,
            )
            .border(
                width = 2.dp,
                color = when {
                    isFocused -> PLAYSOPTTheme.colors.gray5
                    else -> PLAYSOPTTheme.colors.gray2
                },
                shape = RoundedCornerShape(12.dp),
            )
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .padding(16.dp),
        textStyle = PLAYSOPTTheme.typography.body.m18.copy(
            color = PLAYSOPTTheme.colors.black,
        ),
        decorator = TextFieldDecorator { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                ) {
                    if (state.text.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = PLAYSOPTTheme.colors.gray2,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            style = PLAYSOPTTheme.typography.body.m18,
                        )
                    }

                    innerTextField()
                }

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search_24),
                    contentDescription = "검색",
                    tint = PLAYSOPTTheme.colors.gray3,
                    modifier = Modifier
                        .noRippleClickable(onSearchClick)
                        .semantics { role = Role.Button }
                )
            }
        },
        lineLimits = TextFieldLineLimits.SingleLine,
        cursorBrush = SolidColor(PLAYSOPTTheme.colors.gray5),
    )
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
    PlaySoptTheme {
        SearchTextField(
            state = TextFieldState(),
            onSearchClick = {},
            placeholder = "검색어를 입력하세요",
        )
    }
}
