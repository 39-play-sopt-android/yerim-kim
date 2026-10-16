//package org.sopt.play.core.common.navigation
//
//import android.net.http.SslCertificate.saveState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.navigation.NavDestination
//import androidx.navigation.NavDestination.Companion.hasRoute
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navOptions
//import org.sopt.play.presentation.main.model.BottomBarItemModel
//
//class MainNavigator(
//    val navController: NavHostController,
//) {
//    private val currentDestination: NavDestination?
//        @Composable get() = navController
//            .currentBackStackEntryAsState()
//            .value?.destination
//
//    val currentTab: BottomBarItemModel?
//        @Composable get() = BottomBarItemModel.entries.find { tab ->
//            currentDestination?.hasRoute(tab.route::class) == true
//        }
//
//    fun navigate(tab: BottomBarItemModel) {
//        val navOptions = navOptions {
//            popUpTo(BottomBarItemModel.HOME.route) {
//                saveState = true
//            }
//            launchSingleTop = true
//            restoreState = true
//        }
//
//        navController.navigate(tab.route, navOptions)
//    }
//
//    @Composable
//    fun shouldShowBottomBar(): Boolean = currentTab != null
//}
//
//@Composable
//fun rememberMainNavigator(
//    navController: NavHostController = rememberNavController(),
//): MainNavigator = remember(navController) {
//    MainNavigator(navController)
//}