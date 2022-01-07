package com.example.foodapp

import android.app.Application
import com.example.foodapp.model.imageloading.FrescoImageLoading
import com.example.foodapp.model.imageloading.ImageLoading
import com.example.foodapp.model.network.createInstanceApiService
import com.example.foodapp.model.repository.HomeRepository
import com.example.foodapp.model.repository.SliderRepository
import com.example.foodapp.model.source.HomeRemoteDataSource
import com.example.foodapp.model.source.SliderRemoteDataSource
import com.example.foodapp.view.intro.IntroViewModel
import com.example.foodapp.view.main.MainViewModel
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class Application :Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)

        val module = module {
            single { createInstanceApiService() }
            single<ImageLoading> { FrescoImageLoading() }
            factory <SliderRepository>{ SliderRepository(SliderRemoteDataSource(get())) }
            single<HomeRepository> { HomeRepository(HomeRemoteDataSource(get())) }

            viewModel { IntroViewModel(get()) }
            viewModel { MainViewModel(get()) }

        }

        startKoin {
            androidContext(this@Application)
            modules(module)
        }
    }
}