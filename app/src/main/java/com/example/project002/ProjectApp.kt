package com.example.project002

import android.app.Application
import com.example.project002.dl.dataSourceModule
import com.example.project002.dl.repoModule
import com.example.project002.dl.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProjectApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ProjectApp)
            modules(dataSourceModule, repoModule, viewModelModule)
        }
    }
}