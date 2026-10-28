package org.sopt.play.presentation.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptTextField
import org.sopt.play.core.designsystem.preview.FontScalePreviews
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.noRippleClickable
import org.sopt.play.core.util.getEmailError
import org.sopt.play.core.util.getPasswordError

@Composable
fun LoginRoute(
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LoginScreen(
        onLoginClick = onLoginClick,
        onRegisterClick = onRegisterClick,
        modifier = modifier,
    )
}

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()

    val emailError by remember {
        derivedStateOf { getEmailError(emailState.text.toString()) }
    }
    val passwordError by remember {
        derivedStateOf { getPasswordError(passwordState.text.toString()) }
    }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PLAYSOPTTheme.colors.white)
            .imePadding()
            .padding(horizontal = 16.dp)
            .padding(top = 60.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ) {
        Text(
            text = "이메일로 로그인하기",
            color = PLAYSOPTTheme.colors.black,
            style = PLAYSOPTTheme.typography.headline.b28,
        )

        Column {
            PlaySoptTextField(
                state = emailState,
                label = "이메일 주소",
                placeholder = "abc@gmail.com",
                errorMsg = emailError?.let { stringResource(it) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
                onKeyboardAction = {
                    focusManager.moveFocus(FocusDirection.Next)
                },
            )

            Spacer(modifier = Modifier.height(32.dp))

            PlaySoptTextField(
                state = passwordState,
                label = "비밀번호",
                placeholder = "6자 이상의 비밀번호",
                errorMsg = passwordError?.let { stringResource(it) },
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PlaySoptButton(
                text = "로그인",
                onClick = {
                    onLoginClick(
                        emailState.text.toString(),
                        passwordState.text.toString(),
                    )
                },
                enabled = emailState.text.isNotEmpty() &&
                        passwordState.text.isNotEmpty() &&
                        emailError == null &&
                        passwordError == null,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Text(
                    text = "아직 계정이 없으신가요?",
                    color = PLAYSOPTTheme.colors.gray3,
                    style = PLAYSOPTTheme.typography.caption.m14,
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "회원가입하기",
                    color = PLAYSOPTTheme.colors.gray6,
                    style = PLAYSOPTTheme.typography.caption.m14,
                    modifier = Modifier
                        .noRippleClickable(onClick = onRegisterClick)
                        .semantics {
                            role = Role.Button
                        },
                )
            }
        }
    }
}

@FontScalePreviews
@Composable
private fun LoginScreenPreview() {
    PlaySoptTheme {
        LoginScreen(
            modifier = Modifier,
            onLoginClick = { _, _ -> },
            onRegisterClick = {},
        )
    }
}
