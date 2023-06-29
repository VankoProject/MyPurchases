package com.kliachenko.mypurchases.di

import com.kliachenko.mypurchases.presentation.MyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    viewModel {
        MyViewModel(
            getAllShoppingItemsUseCase = get(),
            deleteItemUseCases = get(),
            upsertItemUseCase = get()
        )
    }


}