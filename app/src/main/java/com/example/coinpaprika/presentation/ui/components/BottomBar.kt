package com.example.coinpaprika.presentation.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState

enum class BaseSections(
    val str : String,
    val icon: ImageVector? = null,
    val resource : Int? = null,
    val route : String,
) {
    Home(str = "Home", resource = com.example.coinpaprika.R.drawable.home, route =  "base/home"),
    SEARCH(str = "Search", resource = com.example.coinpaprika.R.drawable.search_alt, route = "base/search"),
    Chart(str="Chart", resource = com.example.coinpaprika.R.drawable.line_up, route = "base/chart" ),
    SETTINGS(str = "Settings", resource = com.example.coinpaprika.R.drawable.setting_line, route = "base/settings"),
}
@Composable
fun BottomNavBar(
    modifier : Modifier = Modifier,
    tabs : Array<BaseSections>,
    navController: NavController,
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute =  navBackStackEntry?.destination?.route
    val sections = remember { BaseSections.values()}
    val routes = remember {sections.map { it.route }}
    if (currentRoute in routes) {
        val currentSection = sections.first {
            it.route == currentRoute
        }
        ElevatedCard(
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 20.dp
            ),
            shape = RoundedCornerShape(topStart = 7.dp, topEnd = 7.dp)
        ) {


            Row(modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(10.dp)
                .fillMaxWidth()
                .height(60.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                tabs.forEach {
                    Box(
                        modifier = modifier.weight(1f)
                    ) {
                        CustomNavigationItem(modifier = modifier,
                            iconId = it.resource ?: 0,
                            title = it.str,
                            selected = currentSection == it,
                            onClick = {
                                      navController.navigate(it.route)

                            },
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    }
                }
            }
        }
    }

}


@Composable
fun CustomNavigationItem(
    modifier : Modifier,
    iconId : Int,
    title : String,
    selected : Boolean,
    onClick : () -> Unit,
    color : Color
){
    val scaleY = remember {
        Animatable(1f)
    }
    val offsetY = remember {
        Animatable(-40f)
    }
    val circlesScale = remember {
        Animatable(0.0f)
    }
    val iconSize by animateDpAsState(targetValue =
    if (selected) 27.dp else 23.dp
    )


    if (selected){
        LaunchedEffect(key1 = selected, block ={
            offsetY.animateTo(0f, animationSpec = tween(durationMillis = 100, delayMillis = 0))
            circlesScale.animateTo(1.2f)
            circlesScale.animateTo(0f)
        } )
        LaunchedEffect(key1 = "second", block ={
            scaleY.animateTo(0.3f, animationSpec = tween(durationMillis =100, delayMillis = 0))
            scaleY.animateTo(1.3f, animationSpec = tween(durationMillis =100, delayMillis =0))
            scaleY.animateTo(1f, animationSpec = tween(durationMillis = 100, delayMillis = 0))
        } )
    }else{
        LaunchedEffect(key1 = selected, block = {
            offsetY.animateTo(-40f)


        })
    }

    Box(
        modifier
            .clip(RoundedCornerShape(20)).clickable {
            onClick()
        }
        ) {


        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier.size(35.dp),
                contentAlignment = Alignment.Center
            ) {
                Spacer(
                    modifier
                        .offset(y = offsetY.value.dp)
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(
                            if (selected) color.copy(0.8f)
                            else Color.Transparent))

                Icon(painter = painterResource(id = iconId),
                    contentDescription = "navigation_item_icon",
                    tint = if (selected) MaterialTheme.colorScheme.onBackground else Color.Gray,
                    modifier = modifier
                        .size(iconSize)
                        .scale(scaleX = scaleY.value, scaleY = scaleY.value)
                )
                Column() {

                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Spacer(modifier = modifier
                            .scale(circlesScale.value)
                            .offset(
                                y = (-7).dp)
                            .clip(CircleShape)
                            .size(5.dp)
                            .background(color))
                        Spacer(modifier = modifier
                            .scale(circlesScale.value)
                            .clip(CircleShape)
                            .size(3.dp)
                            .background(color)
                            .offset(y = (-5).dp))
                    }
                    Spacer(modifier = modifier.size(5.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Spacer(modifier = modifier
                            .scale(circlesScale.value)
                            .clip(CircleShape)
                            .size(3.dp)
                            .background(color)
                            .offset(y = (2).dp))
                        Spacer(modifier = modifier
                            .scale(circlesScale.value)
                            .offset(
                                y = (-10).dp)
                            .clip(CircleShape)
                            .size(5.dp)
                            .background(color))

                    }
                }
            }
            Spacer(modifier = modifier.size(5.dp))
            Text(
                fontSize = if (selected) 14.sp else 9.sp,
                text =title, color = if (selected) color else Color.Gray, style = MaterialTheme.typography.labelMedium, modifier = modifier.scale(scaleY.value))

        }
    }
}




private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)



