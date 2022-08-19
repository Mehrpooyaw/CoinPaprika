package com.example.coinpaprika.presentation.ui.splash

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coinpaprika.R
import kotlinx.coroutines.*
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SplashView(
    modifier: Modifier,
    onNavigate : () -> Unit
){
    val vm = getViewModel<SplashViewModel>()
    val backgroundColor = MaterialTheme.colorScheme.background
    val coroutineScope = rememberCoroutineScope()
    if (vm.shouldNavigate){
        LaunchedEffect(key1 = "navigate" ){
            coroutineScope.launch {
                delay(500)
                onNavigate()
            }
        }
    }
    Surface(
        color = backgroundColor
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(visible = !vm.shouldNavigate, enter = scaleIn(), exit = scaleOut()) {


                AppIconWithShadow(modifier = modifier, shouldEnd = vm.shouldNavigate)

            }
            AnimatedVisibility(visible = !vm.shouldNavigate, enter = fadeIn(), exit = fadeOut()) {

                Column(
                    modifier
                        .fillMaxSize()
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    LinearProgressIndicator(
                        progress = (vm.loadingFloat?.toFloat()?.div(100f)) ?: 0f,
                        modifier = modifier
                            .padding(horizontal = 30.dp, vertical = 20.dp)
                            .fillMaxWidth()
                            .height(3.dp)
                            .clip(CircleShape),
                        color = MaterialTheme.colorScheme.onBackground,
                        trackColor = MaterialTheme.colorScheme.surface,
                    )
                    Spacer(modifier = modifier.size(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val word = "Fetching coins ..."
                        word.forEachIndexed { index, it ->
                            val infiniteTransition = rememberInfiniteTransition()
                            val scale = infiniteTransition.animateFloat(initialValue = 1f,

                                targetValue = 1.3f,
                                animationSpec = InfiniteRepeatableSpec(
                                    initialStartOffset = StartOffset(100 * (index + 1),),
                                    animation = tween(500,500), repeatMode = RepeatMode.Reverse
                                ))
                            val alpha =
                                infiniteTransition.animateFloat(initialValue = 0.5f,
                                    targetValue = 1f,
                                    animationSpec = InfiniteRepeatableSpec(
                                        initialStartOffset = StartOffset(100 * (index + 1),
                                            offsetType = StartOffsetType.Delay),
                                        animation = keyframes {
                                            durationMillis = 500
                                            delayMillis = 500
                                        },
                                        repeatMode = RepeatMode.Reverse,

                                        ))
                            Text(
                                it.toString(), style = MaterialTheme.typography.titleMedium,
                                color = Color.White, modifier = modifier.alpha(alpha.value).scale(scale.value)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AppIconWithShadow(
    modifier : Modifier,
    shouldEnd : Boolean,
){
    val infiniteTransition = rememberInfiniteTransition()
    val offsetYEnd = remember { Animatable(-50f)}
    var shadowScale = infiniteTransition.animateFloat(initialValue = 0.0f,
        targetValue = 1.2f,
        animationSpec = InfiniteRepeatableSpec(
            tween(1000, easing = FastOutSlowInEasing), repeatMode = RepeatMode.Reverse,
        ))
    var offsetY = infiniteTransition.animateFloat(initialValue = offsetYEnd.value,
        targetValue = 50f,
        animationSpec = InfiniteRepeatableSpec(
            tween(1000, easing = FastOutSlowInEasing)
        , repeatMode = RepeatMode.Reverse))
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
            Image(painter = painterResource(id = R.drawable.gold_btc), contentDescription = null,
                modifier = modifier
                    .size(200.dp)
                    .offset(y = offsetY.value.dp)
            
            )
        Card(modifier = modifier
            .scale(shadowScale.value)
            .size(150.dp)
            .graphicsLayer {
                rotationX = 80f
            }, colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(0.4f)
            ), shape = CircleShape){}
        }


}
