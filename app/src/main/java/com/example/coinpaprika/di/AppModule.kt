package com.example.coinpaprika.di

import com.example.coinpaprika.Database
import com.example.coinpaprika.data_source.DefaultLocalSource
import com.example.coinpaprika.data_source.LocalSource
import com.example.coinpaprika.network.DefaultNetworkService
import com.example.coinpaprika.network.NetworkService
import com.example.coinpaprika.presentation.ui.coin.CoinViewModel
import com.example.coinpaprika.repository.CoinPaprikaRepository
import com.example.coinpaprika.repository.DefaultCoinPaprikaRepository
import com.example.coinpaprika.presentation.ui.search.SearchViewModel
import com.example.coinpaprika.presentation.ui.splash.SplashViewModel
import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.Scope
import org.koin.dsl.module

private fun Scope.createDriver(databaseName : String) = AndroidSqliteDriver(Database.Schema, androidContext(),databaseName)


private val viewModelModule = module {
    viewModel {
        SplashViewModel(get())
    }
    viewModel {
        SearchViewModel(get())
    }
    viewModel {
        CoinViewModel(get())
    }
}

private val repositoryModule = module {
    single <CoinPaprikaRepository>{
        DefaultCoinPaprikaRepository()
    }

}


private val dataSourceModule = module {
    factory<LocalSource>{
        DefaultLocalSource(get())
    }
}


private val cacheModule = module {
    single {
        Database(createDriver("coinPaprika"))
    }
}

private val networkModule = module {
    factory<NetworkService> {
        DefaultNetworkService()
    }
}

val androidModules = listOf(viewModelModule, networkModule, cacheModule, repositoryModule,
    dataSourceModule)

