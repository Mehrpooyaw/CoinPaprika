package com.example.coinpaprika

import android.app.Application
import com.example.coinpaprika.di.androidModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(androidModules)
        }
    }
}