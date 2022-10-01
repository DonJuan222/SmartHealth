package com.example.project002.dl

import com.example.project002.data.repositories.HomeRepository
import com.example.project002.data.repositories.LoginRepository
import org.koin.dsl.module

val repoModule = module {
    single { LoginRepository(get(), get(), get()) }
    single { HomeRepository(get(), get(), get())}
}