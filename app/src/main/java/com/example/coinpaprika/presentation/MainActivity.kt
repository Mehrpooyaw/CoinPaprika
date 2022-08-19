package com.example.coinpaprika.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import com.example.coinpaprika.presentation.ui.CoinPaprikaApp
import com.example.coinpaprika.presentation.ui.theme.CoinPaprikaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinPaprikaTheme() {
                CoinPaprikaApp(modifier = Modifier )
            }
        }
    }
}
