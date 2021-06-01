package com.manuflowers.funkosmarket.application

import android.app.Application
import android.content.Context
import com.manuflowers.funkosmarket.data.local.DataFactoryImpl
import com.manuflowers.funkosmarket.data.repository.FunkosRepository
import com.manuflowers.funkosmarket.data.repository.FunkosRepositoryImpl

class FunkosMarketApp : Application() {

    companion object {
        private lateinit var instance: FunkosMarketApp
        fun getAppContext(): Context = instance.applicationContext
    }

    val repository: FunkosRepository by lazy {
        FunkosRepositoryImpl(DataFactoryImpl(getAppContext()))
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}