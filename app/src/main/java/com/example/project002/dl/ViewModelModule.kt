package com.example.project002.dl

import com.example.project002.data.viewmodels.HomeViewModel
import com.example.project002.data.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        LoginViewModel(get())
    }
    viewModel{
        HomeViewModel(get())
    }

}
