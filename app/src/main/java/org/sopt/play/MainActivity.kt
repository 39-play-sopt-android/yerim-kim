package org.sopt.play

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.play.core.designsystem.component.MainTabMenu
import org.sopt.play.core.designsystem.component.MainTopBar
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        onSearchClick = {},
                        modifier = Modifier
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding),
                        )
                }
            }
        }
    }
}



//enum class

@Composable
fun MainScreen(
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
//    selectedTab: MainTab.Home,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        MainTopBar(
            onSearchClick = onSearchClick,
        )

//        LazyRow{
//            items(tabList) { tab ->
//                MainTabMenu(
//                    tabText = tab,
//                    onTabClick = {},
//                )
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PlaySoptTheme {
        MainScreen(
            onSearchClick = {},
        )
    }
}
