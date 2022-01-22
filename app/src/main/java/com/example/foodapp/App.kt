package com.example.foodapp

import android.app.Application
import androidx.room.Room
import com.example.foodapp.model.database.AppDatabase
import com.example.foodapp.model.database.FoodDao
import com.example.foodapp.model.imageloading.FrescoImageLoading
import com.example.foodapp.model.imageloading.ImageLoading
import com.example.foodapp.model.network.createInstanceApiService
import com.example.foodapp.model.repository.*
import com.example.foodapp.model.source.CartRemoteDataSource
import com.example.foodapp.model.source.FoodLocalDataSource
import com.example.foodapp.model.source.FoodRemoteDataSource
import com.example.foodapp.model.source.SliderRemoteDataSource
import com.example.foodapp.view.cart.CartViewModel
import com.example.foodapp.view.detail.DetailViewModel
import com.example.foodapp.view.favorite.FavoriteViewModel
import com.example.foodapp.view.intro.IntroViewModel
import com.example.foodapp.view.main.MainViewModel
import com.example.foodapp.view.search.SearchViewModel
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


class App :Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)

        val module = module {
            single { createInstanceApiService() }
            single { Room.databaseBuilder(this@App , AppDatabase::class.java , "db_app")
                .build()}

            single <ImageLoading>{ FrescoImageLoading() }
            single{ SliderRepository(SliderRemoteDataSource(get())) }
            factory<FoodRepository> {FoodRepositoryImpl(FoodRemoteDataSource(get ()) , FoodLocalDataSource(get<AppDatabase>().FoodDao())) }
            single <SearchRepository>{ SearchRepositoryImpl(get()) }
            single <CartRepository>{CartRepositoryImpl(CartRemoteDataSource(get()))  }

            viewModel { IntroViewModel(get()) }
            viewModel { MainViewModel(get()) }
            viewModel { DetailViewModel(get() , get()) }
            viewModel { FavoriteViewModel(get()) }
            viewModel { SearchViewModel(get()) }
            viewModel { CartViewModel(get()) }

        }

        startKoin {
            androidContext(this@App)
            modules(module)
        }
    }
}