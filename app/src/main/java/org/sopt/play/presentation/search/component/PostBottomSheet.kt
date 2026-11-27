package org.sopt.play.presentation.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.sopt.play.core.designsystem.component.PlaySoptBottomSheet
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptTextField
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostBottomSheet(
    onDismissRequest: () -> Unit,
    titleState: TextFieldState,
    contentState: TextFieldState,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    bottomSheetState: SheetState = rememberModalBottomSheetState(),
) {
    PlaySoptBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        bottomSheetState = bottomSheetState,
        content = {
            BottomSheetContent(
                onDismissRequest = onDismissRequest,
                titleState = titleState,
                contentState = contentState,
                onButtonClick = onButtonClick,
                bottomSheetState = bottomSheetState,
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomSheetContent(
    onDismissRequest: () -> Unit,
    titleState: TextFieldState,
    contentState: TextFieldState,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    bottomSheetState: SheetState = rememberModalBottomSheetState(),
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        PlaySoptTextField(
            state = titleState,
            label = "제목",
            placeholder = "제목을 입력하세요",
            maxLength = 20,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
            ),
        )

        Spacer(modifier = Modifier.height(12.dp))

        PlaySoptTextField(
            state = contentState,
            label = "본문",
            placeholder = "본문을 입력하세요",
            maxLength = 1000,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
            ),
        )

        Spacer(modifier = Modifier.height(20.dp))

        PlaySoptButton(
            text = "완료",
            onClick = {
                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                    if (!bottomSheetState.isVisible) {
                        onButtonClick()
                        onDismissRequest()
                    }
                }
            },
            enabled = titleState.text.isNotBlank() && contentState.text.isNotBlank(),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun BottomSheetContentPreview() {
    var showBottomSheet by remember { mutableStateOf(false) }

    PlaySoptTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = PLAYSOPTTheme.colors.white)
                .padding(bottom = 80.dp, end = 20.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom,
        ) {
            FloatingButton(
                onButtonClick = { showBottomSheet = true },
            )

            if (showBottomSheet) {
                PostBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    titleState = TextFieldState(),
                    contentState = TextFieldState(),
                    onButtonClick = {},
                )
            }
        }
    }
}
