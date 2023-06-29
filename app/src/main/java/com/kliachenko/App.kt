package com.kliachenko

import android.app.Application
import com.kliachenko.mypurchases.di.appModule
import com.kliachenko.mypurchases.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule, dataModule)
        }
    }
}