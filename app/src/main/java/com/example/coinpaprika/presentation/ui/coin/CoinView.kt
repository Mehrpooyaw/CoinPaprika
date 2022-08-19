package com.example.coinpaprika.presentation.ui.coin

import android.widget.Space
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.coinpaprika.domain.models.coin.CoinTwitter
import com.example.coinpaprika.presentation.ui.chart.CandleStick
import com.example.coinpaprika.presentation.ui.components.TextWithShadow
import com.example.coinpaprika.presentation.ui.splash.AppIconWithShadow
import com.example.coinpaprika.presentation.ui.theme.AlmostYellow
import com.example.coinpaprika.presentation.ui.theme.NeonGreen
import com.example.coinpaprika.presentation.ui.theme.NeonPink
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import kotlinx.coroutines.delay
import org.koin.androidx.compose.getViewModel
import java.math.BigDecimal
import kotlin.math.round

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CoinView(
    modifier: Modifier,
    id : String
){
    val vm = getViewModel<CoinViewModel>()

    val favoriteColor by animateColorAsState(
        targetValue = if (vm.isFavorite) Color.Red else MaterialTheme.colorScheme.onBackground

    )
    var isExchangesExpanded by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = "first_launch", block = {
        vm.initialize(id)
    } )
    if (vm.errorMessages.filterNotNull().isEmpty()){
        if (!vm.loading && !vm.forceLoading){
            if ((vm.coin != null || vm.coinExchanges.isNotEmpty() || vm.coinTwitter.isNotEmpty()) && !vm.loading) {
                Column() {
                    Row(
                        modifier = modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        vm.coin?.name?.let {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextWithShadow(
                                    text = it,
                                    style = MaterialTheme.typography.displaySmall,

                                )
                                Spacer(modifier = modifier.size(5.dp))
                                if (vm.coinMarkets.isNotEmpty() && vm.coinMarkets[0]?.quotes?.kEY?.price != null) {

                                    TextWithShadow(
                                        style = MaterialTheme.typography.labelSmall,
                                        color = NeonGreen,
                                        text = (BigDecimal(vm.coinMarkets[0]?.quotes?.kEY?.price!!).round(7) .toString().removeEndZeros()))
                                }
                            }
                        }
                        IconButton(onClick = {
                            vm.isFavorite = !vm.isFavorite

        //                    TODO("Set to favorites")
                        }) {
                            Icon(imageVector = Icons.Rounded.Favorite,
                                contentDescription = null,
                                tint = favoriteColor)
                        }
                    }
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .animateContentSize(),
                    contentPadding = PaddingValues(vertical = 20.dp)
                ) {

                    if (vm.coinOHLC.value != null) {
                        item {
                            AnimatedVisibility(
                                enter = scaleIn(), exit = scaleOut(),
                                visible = vm.coinOHLC.value != null && vm.coinOHLC.value?.result?.x86400?.isNotEmpty() == true) {


                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    CandleStick(modifier = modifier,
                                        list = vm.coinOHLC.value?.result?.x60)
                                    TextWithShadow(text = "${vm.coin?.symbol}/usdt".uppercase() + "  with few days delay (free API)")
                                }
                            }
                        }
                    }else{
                        if (vm.errorMessages.isEmpty()) {
                            item {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {


                                    Row(modifier = modifier
                                        .padding(7.dp)
                                        .fillMaxWidth()
                                        .aspectRatio(16 / 9f)) {
                                        Column(
                                            modifier = modifier
                                                .width(50.dp)
                                                .fillMaxHeight(),
                                            verticalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            repeat(6) {
                                                Text("1000", modifier.placeholder(
                                                    true,
                                                    highlight = PlaceholderHighlight.shimmer(),
                                                    color = Color.Gray
                                                ), style = MaterialTheme.typography.labelMedium)
                                            }

                                        }
                                        Box(
                                            modifier = modifier
                                                .padding(end = 5.dp, bottom = 3.dp)
                                                .fillMaxSize()
                                                .placeholder(
                                                    visible = true,
                                                    highlight = PlaceholderHighlight.shimmer(),
                                                    color = Color.Gray
                                                )
                                        )
                                    }
                                    Text("BTC/USDT with few days delay(free API)", modifier.placeholder(
                                        true,
                                        highlight = PlaceholderHighlight.shimmer(),
                                        color = Color.Gray,
                                    ), style = MaterialTheme.typography.labelMedium)


                                }
                            }
                        }
                    }
                    if (vm.coinEvent.isNotEmpty()) {
                        item {
                            Box(modifier = modifier
                                .padding(5.dp)
                                .padding(top = 15.dp)) {
                                TextWithShadow(text = "Events",
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = AlmostYellow)
                            }
                        }
                        items(vm.coinEvent) {
                            LazyRow() {

                            }

                        }
                    }
                    if (vm.coinMarkets.size > 5) {
                        item {
                            Box(modifier = modifier
                                .padding(5.dp)
                                .padding(top = 15.dp)) {
                                TextWithShadow(text = "Exchanges",
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = AlmostYellow)
                            }
                        }

                            item {
                            LazyColumn(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .height(height = 230.dp)
                                    .padding(vertical = 20.dp),
                            ) {
                                items(if (isExchangesExpanded) vm.coinMarkets else vm.coinMarkets.subList(0,
                                    5)) {


                                    Row(
                                        modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            it?.exchangeName?.let { it1 ->
                                                TextWithShadow(text = it1,
                                                    style = MaterialTheme.typography.titleSmall
                                                )
                                            }
                                            Spacer(modifier = modifier.size(5.dp))
                                            it?.quoteCurrencyName?.let { it2 ->
                                                Text(it2,
                                                    style = MaterialTheme.typography.labelMedium,
                                                    color = Color.Gray)
                                            }
                                        }
                                        it?.quotes?.kEY?.price?.let {
                                            TextWithShadow(text = it.toString(), color = NeonPink)
                                        }

                                    }
                                }
                            }
                        }
                        item {
                            OutlinedButton(
                                modifier = modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                                onClick = {
                                isExchangesExpanded = !isExchangesExpanded
                            }) {
                                Text(if (isExchangesExpanded) "Lock scroll" else "Unlock scroll")

                            }
                        }
                    }
                    if (vm.coinTwitter.isNotEmpty()){
                    item {
                        Box(modifier = modifier
                            .padding(5.dp)
                            .padding(top = 15.dp)) {
                            TextWithShadow(text = "Tweets",
                                color = AlmostYellow,
                                style = MaterialTheme.typography.headlineMedium)
                        }
                    }
                    items(vm.coinTwitter) {
                        if (it != null) {
                            TweetItem(modifier = modifier, tweet = it)
                        }

                    }
                    }

                }
                }
            }
            else {

            }
        }
            else {
                vm.forceLoading = true
                LaunchedEffect(key1 = "force_loading" ){
                    delay(1500)
                    vm.forceLoading = false
                }
                Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    AppIconWithShadow(modifier = modifier, shouldEnd = !vm.loading)
                }
            }
    }else {
        Column() {
            vm.errorMessages.forEach{
                if (it != null) {
                    TextWithShadow(text = it)
                }
            }
        }
    }
}



@Composable
fun TweetItem(
    modifier : Modifier,
    tweet : CoinTwitter
) {
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (tweet.userImageLink != null) {
                Card(
                    shape = CircleShape,
                    modifier = modifier
                        .padding(10.dp)
                        .size(50.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 20.dp
                    )
                ) {
                    Image(painter = rememberAsyncImagePainter(model = tweet.userImageLink.replace("https",
                        "http").replace("http", "https")),
                        contentDescription = "tweet_user_image",
                        modifier = modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds)
                }
            }
            Spacer(modifier = modifier.size(5.dp))
            Column() {
                tweet.userName?.let { TextWithShadow(text = it, style = MaterialTheme.typography.labelLarge) }
                Spacer(modifier = modifier.size(5.dp))
                tweet.date?.let { TextWithShadow(
                    color = Color.Gray,
                    text = it.replace("T","at").replace("Z",""), style = MaterialTheme.typography.labelSmall) }
            }

        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 80.dp)
        ){
            tweet.status?.let { TextWithShadow(text = it) }
        }
        tweet.mediaLink?.let {
            Box(
                modifier = modifier
                    .padding(start = 68.dp)
                    .fillMaxWidth()
                    .padding(7.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .aspectRatio(16 / 9f),
                    shape = RoundedCornerShape(18.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    )
                ) {
                    Image(modifier = modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                        painter = rememberAsyncImagePainter(
                            model = it.replace("https","http").replace("http","https")),
                        contentDescription = null)


                }

            }
        }
        Row(
            modifier = modifier
                .padding(start = 80.dp, top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row() {
                Icon(Icons.Rounded.FavoriteBorder,
                    null,
                   tint = Color.Gray)
                Spacer(modifier = modifier.size(5.dp))
                TextWithShadow(text = tweet.likeCount.toString(), color = Color.Gray)
            }

        }

        Spacer(modifier = modifier.size(20.dp))
        Divider(
            modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onBackground)
        )
        Spacer(modifier = modifier.size(5.dp))

    }
}






fun String.removeEndZeros(count : Int = 4) : String{
    val last4Char = this.substring(this.length - count, this.length)
    if (last4Char == "0000"){
        return this.replace("0000","0")
    }
    return this
}

fun BigDecimal.round(decimals: Int = 2): BigDecimal = "%.${decimals}f".format(this).toBigDecimal()