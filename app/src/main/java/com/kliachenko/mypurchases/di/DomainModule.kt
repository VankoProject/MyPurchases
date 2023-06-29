package com.kliachenko.mypurchases.di

import com.kliachenko.mypurchases.domain.usecases.DeleteItemUseCases
import com.kliachenko.mypurchases.domain.usecases.GetAllShoppingItemsUseCase
import com.kliachenko.mypurchases.domain.usecases.UpsertItemUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        DeleteItemUseCases(repository = get())
    }

    factory {
        GetAllShoppingItemsUseCase(repository = get())
    }

    factory {
        UpsertItemUseCase(repository = get())
    }
}