package com.example.coinpaprika.presentation.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.coinpaprika.presentation.ui.components.BaseSections
import com.example.coinpaprika.presentation.ui.components.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinPaprikaApp(
    modifier : Modifier,
){
    val navController = rememberNavController()
    val sections = remember { BaseSections.values()}
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = { BottomNavBar(tabs = sections, navController =navController ) }
    ) {

        AppNavigation(modifier = modifier, navController = navController)
    }
}