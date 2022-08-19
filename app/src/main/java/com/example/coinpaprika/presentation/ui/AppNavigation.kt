package com.example.coinpaprika.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coinpaprika.presentation.ui.coin.CoinView
import com.example.coinpaprika.presentation.ui.components.BaseSections
import com.example.coinpaprika.presentation.ui.components.addBaseGraph
import com.example.coinpaprika.presentation.ui.splash.SplashView

@Composable
fun AppNavigation(
    modifier: Modifier,
    navController : NavHostController,
    startDestination : String = Routes.SPLASH_SCREEN
){

    NavHost(navController = navController, startDestination =startDestination ){
       navigation(route = "base",startDestination = BaseSections.Home.route,){
        addBaseGraph(modifier,navController){
            navController.navigate("${Routes.COIN_SCREEN}/$it")
        }
        }
        composable(Routes.SPLASH_SCREEN){
            SplashView(modifier = modifier, onNavigate = {
                navController.navigate(BaseSections.Home.route)
            })
        }
        composable("${Routes.COIN_SCREEN}/{id}", arguments = listOf(navArgument(
            name = "id",
        ){
            type = NavType.StringType
        })){
            val arg = it.arguments?.getString("id")
            if (arg != null) {
                CoinView(modifier = modifier,id = arg)
            }
        }

    }
}



class Routes {
    companion object {
        const val SPLASH_SCREEN = "splash"
        const val COIN_SCREEN = "coinScreen"

    }
}