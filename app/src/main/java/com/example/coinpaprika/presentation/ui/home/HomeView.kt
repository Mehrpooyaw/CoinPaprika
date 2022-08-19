package com.example.coinpaprika.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.coinpaprika.R
import com.example.coinpaprika.presentation.ui.components.HomeCategoryItem

@Composable
fun HomeView(
    modifier : Modifier,
    onNavigateToCoinScreen : (String) -> Unit
){

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(5))

        ) {
            Box(modifier = modifier
                .fillMaxSize()
                .background(Brush.linearGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary.copy(1f),
                        MaterialTheme.colorScheme.secondary.copy(1f)
                    ).reversed()
                )).padding(5.dp)
                .blur(30.dp))
            Column(
                modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier.fillMaxWidth().weight(1f), verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier.padding(10.dp)
                            .weight(1f)
                           
                    ) {

                        HomeCategoryItem(modifier = modifier,
                            resource = R.drawable.ethereum,
                            title = "Ethereum") {
                           onNavigateToCoinScreen("eth-ethereum")
                        }
                    }
                    Box(
                        modifier.padding(10.dp)
                            .weight(1f)

                    ) {
                        HomeCategoryItem(modifier = modifier,
                            resource = R.drawable.matic,
                            title = "Matic") {
                            onNavigateToCoinScreen("matic-polygon")
                        }
                    }
                    Box(
                        modifier.padding(10.dp)
                            .weight(1f)

                    ) {
                        HomeCategoryItem(modifier = modifier,
                            resource = R.drawable.dash,
                            title = "Dash") {
                            onNavigateToCoinScreen("dash-dash")
                        }


                    }
                }
                Row(
                    modifier.fillMaxWidth().weight(1f), verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier.padding(10.dp)
                            .weight(1f)

                    ) {
                        HomeCategoryItem(modifier = modifier,
                            resource = R.drawable.yellow_btc,
                            title = "Bitcoin") {
                           onNavigateToCoinScreen("btc-bitcoin")
                        }
                    }
                    Box(
                        modifier.padding(10.dp)
                            .weight(1f)

                    ) {
                        HomeCategoryItem(modifier = modifier,
                            resource = R.drawable.bnb,
                            title = "BNB") {
                            onNavigateToCoinScreen("bnb-binance-coin")
                        }
                    }
                    Box(
                        modifier.padding(10.dp)
                            .weight(1f)

                    ) {
                        HomeCategoryItem(modifier = modifier,
                            resource = R.drawable.cardano,
                            title = "Cardano") {
                           onNavigateToCoinScreen("ada-cardano")
                        }
                    }

                }
                Row(
                    modifier.fillMaxWidth().weight(1f), verticalAlignment = Alignment.CenterVertically,
                ){
                    Box(
                        modifier.padding(10.dp)
                            .weight(1f)

                    ) {
                        HomeCategoryItem(modifier = modifier,
                            resource = R.drawable.shiba,
                            title = "Shiba") {
                            onNavigateToCoinScreen("shib-shiba-inu")
                        }
                    }
                        Box(
                            modifier.padding(10.dp)
                                .weight(1f)
                                .aspectRatio(1f)
                        ) {
                            HomeCategoryItem(modifier = modifier,
                                resource = R.drawable.trx,
                                title = "Tron") {
                                onNavigateToCoinScreen("trx-tron")
                            }
                        }
                        Box(
                            modifier.padding(10.dp)
                                .weight(1f)
                                .aspectRatio(1f)
                        ) {
                            HomeCategoryItem(modifier = modifier,
                                resource = R.drawable.polkadot,
                                title = "Polkadot") {
                                onNavigateToCoinScreen("dot-polkadot")
                            }
                        }
                    }


            }
        }
    }
}