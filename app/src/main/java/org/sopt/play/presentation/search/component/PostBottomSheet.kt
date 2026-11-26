package org.sopt.play.presentation.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.component.CustomDragHandle
import org.sopt.play.core.designsystem.component.PlaySoptBottomSheet
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptTextField
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostBottomSheet(
    titleState: TextFieldState,
    contentState: TextFieldState,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PlaySoptBottomSheet(
        onDismissRequest = {},
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
    contentState: TextFieldState,
    onButtonClick: () -> Unit,
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
private fun BottomSheetContentPreview() {
    PlaySoptTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = PLAYSOPTTheme.colors.white,
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp,
                    )
                )
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomDragHandle()

            BottomSheetContent(
                titleState = TextFieldState(),
                contentState = TextFieldState(),
                onButtonClick = {},
            )

            Box(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .width(108.dp)
                    .height(4.dp)
                    .background(
                        color = PLAYSOPTTheme.colors.black,
                        shape = CircleShape,
                    )
            )
        }
    }
}
