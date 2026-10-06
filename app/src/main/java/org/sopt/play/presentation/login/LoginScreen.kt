package org.sopt.play.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptTextField
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.isEmailValid

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PLAYSOPTTheme.colors.white)
            .padding(horizontal = 16.dp)
            .padding(top = 60.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ) {
        Text(
            text = "이메일로 로그인하기",
            style = PLAYSOPTTheme.typography.headline.b28.copy(
                color = PLAYSOPTTheme.colors.black,
            ),
        )

        Column {
            PlaySoptTextField(
                state = emailState,
                label = "이메일 주소",
                placeholder = "abc@gmail.com",
                errorMsg = if (emailState.text.isNotEmpty() && !isEmailValid(emailState.text.toString())) "올바른 이메일을 입력해주세요." else null,
            )

            Spacer(modifier = Modifier.height(32.dp))

            PlaySoptTextField(
                state = passwordState,
                label = "비밀번호",
                placeholder = "6자 이상의 비밀번호",
                errorMsg = if (passwordState.text.isNotEmpty() && passwordState.text.length < 6) "비밀번호는 6자 이상 입력해주세요." else null,
                isPassword = true,
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PlaySoptButton(
                text = "로그인",
                onClick = onLoginClick,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Text(
                    text = "아직 계정이 없으신가요?",
                    style = PLAYSOPTTheme.typography.caption.m14.copy(
                        color = PLAYSOPTTheme.colors.gray3,
                    ),
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "회원가입하기",
                    style = PLAYSOPTTheme.typography.caption.m14.copy(
                        color = PLAYSOPTTheme.colors.gray6,
                    ),
                    modifier = Modifier.clickable(onClick = onSignUpClick)
                )
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    PlaySoptTheme {
        LoginScreen(
            modifier = Modifier,
            onLoginClick = {},
            onSignUpClick = {},
        )
    }
}
