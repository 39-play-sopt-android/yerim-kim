package org.sopt.play.presentation.main.ui

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.sopt.play.core.common.navigation.AppNavHost
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.presentation.main.component.MainBottomBar
import org.sopt.play.presentation.main.model.BottomBarItemModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val selectedTab = BottomBarItemModel.entries.find { tab ->
        currentDestination?.hasRoute(tab.route::class) == true
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = PLAYSOPTTheme.colors.white,
        bottomBar = {
            if (selectedTab != null) {
                MainBottomBar(
                    selectedTab = selectedTab,
                    onTabClick = { tab ->
                        navController.navigate(tab.route) {
                            launchSingleTop = true
                        }
                    },
                )
            }
        },
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding),
        )
    }
}
