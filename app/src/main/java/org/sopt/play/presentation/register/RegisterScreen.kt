package org.sopt.play.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
fun RegisterScreen(
    onRegisterClick: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val nameState = rememberTextFieldState()
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    val passwordCheckState = rememberTextFieldState()

    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PLAYSOPTTheme.colors.white)
            .imePadding()
            .verticalScroll(scrollState)
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
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                ),
                onKeyboardAction = {
                    focusManager.moveFocus(FocusDirection.Next)
                },
            )

            PlaySoptTextField(
                state = emailState,
                label = "이메일 주소",
                placeholder = "abc@email.com",
                errorMsg = if (isEmailValid(emailState.text.toString())
                    || emailState.text.isEmpty()
                ) null else stringResource(R.string.invalid_email),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
                onKeyboardAction = {
                    focusManager.moveFocus(FocusDirection.Next)
                },
            )

            PlaySoptTextField(
                state = passwordState,
                label = "비밀번호",
                placeholder = "6자 이상의 비밀번호",
                errorMsg = if (isPasswordValid(passwordState.text.toString())
                    || passwordState.text.isEmpty()
                ) null else stringResource(R.string.short_password),
                isPassword = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
                ),
                onKeyboardAction = {
                    focusManager.moveFocus(FocusDirection.Next)
                },
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                onKeyboardAction = {
                    focusManager.clearFocus()
                },
            )
        }

        PlaySoptButton(
            text = "회원가입",
            onClick = {
                onRegisterClick(
                    emailState.text.toString(),
                    passwordState.text.toString()
                )
            },
            enabled = isEmailValid(emailState.text.toString())
                    && isPasswordValid(passwordState.text.toString())
                    && isPasswordCheckValid(
                passwordState.text.toString(),
                passwordCheckState.text.toString()
            ),
        )
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    PlaySoptTheme {
        RegisterScreen(
            onRegisterClick = { _, _ -> }
        )
    }
}
