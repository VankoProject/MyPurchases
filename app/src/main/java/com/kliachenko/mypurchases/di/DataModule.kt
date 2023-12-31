package com.kliachenko.mypurchases.di

import androidx.room.Room
import com.kliachenko.mypurchases.data.RepositoryImpl
import com.kliachenko.mypurchases.data.database.ShoppingDatabase
import com.kliachenko.mypurchases.domain.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            ShoppingDatabase::class.java,
            ShoppingDatabase.DB
        ).build()
    }

    single {
        get<ShoppingDatabase>().getShoppingDao()
    }

    single<Repository> {
        RepositoryImpl(
            dao = get()
        )
    }
}