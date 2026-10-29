package org.sopt.play.presentation.auth.register

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptTextField
import org.sopt.play.core.designsystem.preview.FontScalePreviews
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun RegisterRoute(
    state: RegisterUiState,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordCheckChange: (String) -> Unit,
    onRegisterClick: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    RegisterScreen(
        state = state,
        onNameChange = onNameChange,
        onEmailChange = onEmailChange,
        onPasswordChange = onPasswordChange,
        onPasswordCheckChange = onPasswordCheckChange,
        onRegisterClick = onRegisterClick,
        modifier = modifier,
    )
}

@Composable
fun RegisterScreen(
    state: RegisterUiState,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordCheckChange: (String) -> Unit,
    onRegisterClick: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val nameState = rememberTextFieldState(state.name)
    val emailState = rememberTextFieldState(state.email)
    val passwordState = rememberTextFieldState(state.password)
    val passwordCheckState = rememberTextFieldState(state.passwordCheck)

    LaunchedEffect(nameState) {
        snapshotFlow { nameState.text.toString() }
            .collect { onNameChange(it) }
    }

    LaunchedEffect(emailState) {
        snapshotFlow { emailState.text.toString() }
            .collect { onEmailChange(it) }
    }

    LaunchedEffect(passwordState) {
        snapshotFlow { passwordState.text.toString() }
            .collect { onPasswordChange(it) }
    }

    LaunchedEffect(passwordCheckState) {
        snapshotFlow { passwordCheckState.text.toString() }
            .collect { onPasswordCheckChange(it) }
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
                errorMsg = state.emailError?.let { stringResource(it) },
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
                errorMsg = state.passwordError?.let { stringResource(it) },
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
                errorMsg = state.passwordCheckError?.let { stringResource(it) },
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
            enabled = state.isRegisterEnabled
        )
    }
}

@FontScalePreviews
@Composable
private fun RegisterScreenPreview() {
    PlaySoptTheme {
        RegisterScreen(
            state = RegisterUiState(),
            onNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onPasswordCheckChange = {},
            onRegisterClick = { _, _ -> }
        )
    }
}
