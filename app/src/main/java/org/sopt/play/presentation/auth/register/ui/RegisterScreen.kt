package org.sopt.play.presentation.auth.register.ui

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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptTextField
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.util.getEmailError
import org.sopt.play.core.util.getPasswordCheckError
import org.sopt.play.core.util.getPasswordError

@Composable
fun RegisterRoute(
    onRegisterClick: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    RegisterScreen(
        onRegisterClick = onRegisterClick,
        modifier = modifier,
    )
}

@Composable
fun RegisterScreen(
    onRegisterClick: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val nameState = rememberTextFieldState()
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    val passwordCheckState = rememberTextFieldState()

    val emailError by remember {
        derivedStateOf { getEmailError(emailState.text.toString()) }
    }
    val passwordError by remember {
        derivedStateOf { getPasswordError(passwordState.text.toString()) }
    }
    val passwordCheckError by remember {
        derivedStateOf {
            getPasswordCheckError(
                passwordState.text.toString(),
                passwordCheckState.text.toString()
            )
        }
    }

    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PLAYSOPTTheme.colors.white)
            .imePadding()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 60.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ) {
        Text(
            text = "이메일로 회원가입",
            color = PLAYSOPTTheme.colors.black,
            style = PLAYSOPTTheme.typography.headline.b28,
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
                errorMsg = emailError?.let { stringResource(it) },
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
                errorMsg = passwordError?.let { stringResource(it) },
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
                errorMsg = passwordCheckError?.let { stringResource(it) },
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
            enabled = nameState.text.isNotEmpty() &&
                    emailState.text.isNotEmpty() &&
                    passwordState.text.isNotEmpty() &&
                    passwordCheckState.text.isNotEmpty() &&
                    emailError == null &&
                    passwordError == null &&
                    passwordCheckError == null,
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
