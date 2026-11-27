package org.sopt.play.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaySoptBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    bottomSheetState: SheetState = rememberModalBottomSheetState(),
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = bottomSheetState,
        sheetMaxWidth = Dp.Unspecified,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        containerColor = PLAYSOPTTheme.colors.white,
        scrimColor = PLAYSOPTTheme.colors.black.copy(alpha = 0.4f),
        dragHandle = { CustomDragHandle() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            content()

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

@Composable
fun CustomDragHandle(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(top = 12.dp, bottom = 20.dp)
            .width(36.dp)
            .height(4.dp)
            .background(
                color = PLAYSOPTTheme.colors.gray3,
                shape = CircleShape,
            )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun PlaySoptBottomSheetPreview() {
    var showBottomSheet by remember { mutableStateOf(false) }

    PlaySoptTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = PLAYSOPTTheme.colors.white),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = { showBottomSheet = true },
            ) {
                Text(
                    text = "플로팅 버튼",
                    color = PLAYSOPTTheme.colors.white,
                )
            }

            if (showBottomSheet) {
                PlaySoptBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    content = {
                        Box(modifier = Modifier.height(200.dp))
                    }
                )
            }
        }
    }
}
