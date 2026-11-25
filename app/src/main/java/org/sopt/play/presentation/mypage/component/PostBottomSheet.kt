package org.sopt.play.presentation.mypage.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.component.BottomSheet
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptTextField
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun PostBottomSheet(
    titleState: TextFieldState,
    contentState: TextFieldState,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BottomSheet(
        modifier = modifier,
        content = {
            BottomSheetContent(
                titleState = titleState,
                contentState = contentState,
                onButtonClick = onButtonClick,
            )
        }
    )
}

@Composable
private fun BottomSheetContent(
    titleState: TextFieldState,
    contentState: TextFieldState,    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        PlaySoptTextField(
            state = titleState,
            label = "제목",
            placeholder = "제목을 입력하세요",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
            ),
        )

        Spacer(modifier = Modifier.height(12.dp))

        PlaySoptTextField(
            state = contentState,
            label = "본문",
            placeholder = "본문을 입력하세요",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
            ),
        )

        Spacer(modifier = Modifier.height(20.dp))

        PlaySoptButton(
            text = "완료",
            onClick = onButtonClick,
            enabled = titleState.text.isNotBlank() && contentState.text.isNotBlank(),
        )
    }
}

@Preview
@Composable
private fun PostBottomSheetPreview() {
    PlaySoptTheme {
        PostBottomSheet(
            titleState = TextFieldState(),
            contentState = TextFieldState(),
            onButtonClick = {},
        )
    }
}
