package org.sopt.play.core.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.sopt.play.R
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun PlaySoptTextField(
    state: TextFieldState,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    errorMsg: String? = null,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onKeyboardAction: KeyboardActionHandler? = null,
) {
    var isFocused by remember { mutableStateOf(false) }
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .bringIntoViewRequester(bringIntoViewRequester),
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(start = 8.dp, bottom = 6.dp),
            style = PLAYSOPTTheme.typography.body.sb16,
            color = PLAYSOPTTheme.colors.gray6,
        )

        BasicTextField(
            state = state,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(12.dp),
                    color = PLAYSOPTTheme.colors.white,
                )
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(12.dp),
                    color = if (errorMsg != null) PLAYSOPTTheme.colors.red
                    else if (isFocused) PLAYSOPTTheme.colors.gray5
                    else PLAYSOPTTheme.colors.gray2
                )
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused

                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                }
                .padding(16.dp),
            textStyle = PLAYSOPTTheme.typography.body.m18.copy(
                color = PLAYSOPTTheme.colors.black
            ),
            decorator = TextFieldDecorator { innerTextField ->
                Box {
                    if (state.text.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = PLAYSOPTTheme.typography.body.m18,
                            color = PLAYSOPTTheme.colors.gray2,
                        )
                    }

                    innerTextField()
                }
            },
            outputTransformation = if (isPassword) OutputTransformation {
                repeat(length) {
                    replace(it, it + 1, "•")
                }
            } else null,
            lineLimits = TextFieldLineLimits.SingleLine,
            cursorBrush = SolidColor(PLAYSOPTTheme.colors.gray5),
            keyboardOptions = keyboardOptions,
            onKeyboardAction = onKeyboardAction,
        )

        AnimatedVisibility(
            visible = !errorMsg.isNullOrEmpty(),
            enter = expandVertically(),
            exit = shrinkVertically(
                animationSpec = tween(100)
            ),
        ) {
            Text(
                text = errorMsg ?: "",
                modifier = Modifier
                    .padding(start = 8.dp, top = 6.dp)
                    .imePadding(),
                style = PLAYSOPTTheme.typography.caption.m14.copy(
                    color = PLAYSOPTTheme.colors.red,
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlaySoptTextFieldPreview() {
    PlaySoptTheme {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PlaySoptTextField(
                state = rememberTextFieldState(),
                label = "이메일 주소",
                placeholder = "abc@email.com",
                modifier = Modifier,
            )

            PlaySoptTextField(
                state = rememberTextFieldState("yerim@email.com"),
                label = "이메일 주소",
                placeholder = "abc@email.com",
                modifier = Modifier,
            )

            PlaySoptTextField(
                state = rememberTextFieldState("a12345678"),
                label = "비밀번호",
                placeholder = "6자 이상의 비밀번호",
                modifier = Modifier,
                isPassword = true,
            )

            PlaySoptTextField(
                state = rememberTextFieldState("abc.com"),
                label = "이메일 주소",
                placeholder = "abc@email.com",
                modifier = Modifier,
                errorMsg = stringResource(R.string.invalid_email),
            )
        }
    }
}
