package org.sopt.play.presentation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptTextField
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.isEmailValid
import org.sopt.play.core.extension.isPasswordCheckValid
import org.sopt.play.core.extension.isPasswordValid

@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val nameState = rememberTextFieldState()
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    val passwordCheckState = rememberTextFieldState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PLAYSOPTTheme.colors.white)
            .padding(horizontal = 16.dp)
            .padding(top = 60.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ) {
        Text(
            text = "이메일로 회원가입",
            style = PLAYSOPTTheme.typography.headline.b28.copy(
                color = PLAYSOPTTheme.colors.black,
            ),
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            PlaySoptTextField(
                state = nameState,
                label = "이름",
                placeholder = "홍길동",
            )

            PlaySoptTextField(
                state = emailState,
                label = "이메일 주소",
                placeholder = "abc@email.com",
                errorMsg = if (isEmailValid(emailState.text.toString())
                    || emailState.text.isEmpty()
                ) null else stringResource(R.string.invalid_email),
            )

            PlaySoptTextField(
                state = passwordState,
                label = "비밀번호",
                placeholder = "6자 이상의 비밀번호",
                errorMsg = if (isPasswordValid(passwordState.text.toString())
                    || passwordState.text.isEmpty()
                ) null else stringResource(R.string.short_password),
                isPassword = true,
            )

            PlaySoptTextField(
                state = passwordCheckState,
                label = "비밀번호 확인",
                placeholder = "6자 이상의 비밀번호",
                errorMsg = if (isPasswordCheckValid(
                        passwordState.text.toString(),
                        passwordCheckState.text.toString()
                    )
                    || passwordCheckState.text.isEmpty()
                ) null else stringResource(R.string.different_password),
                isPassword = true,
            )
        }

        PlaySoptButton(
            text = "회원가입",
            onClick = onSignUpClick,
            enabled = isEmailValid(emailState.text.toString())
                    && isPasswordValid(passwordState.text.toString())
                    && isPasswordCheckValid(passwordState.text.toString(),passwordCheckState.text.toString()),
        )
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    PlaySoptTheme {
        SignUpScreen(
            onSignUpClick = {},
        )
    }
}
