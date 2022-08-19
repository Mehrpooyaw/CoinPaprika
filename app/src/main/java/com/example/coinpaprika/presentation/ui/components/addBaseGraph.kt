package com.example.coinpaprika.presentation.ui.components

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coinpaprika.presentation.ui.Routes
import com.example.coinpaprika.presentation.ui.home.HomeView
import com.example.coinpaprika.presentation.ui.search.SearchView

fun NavGraphBuilder.addBaseGraph(
    modifier : Modifier,
    navController: NavController,
    onNavigateToCoinScreen : (String) -> Unit
){
    composable(BaseSections.Home.route) {
            HomeView(
               modifier, onNavigateToCoinScreen = onNavigateToCoinScreen )

    }
    composable(BaseSections.SEARCH.route){
        SearchView(modifier = modifier){
            navController.navigate("${Routes.COIN_SCREEN}/$it")
        }

    }

    composable(BaseSections.Chart.route){

    }
    composable(BaseSections.SETTINGS.route) {
    }

}