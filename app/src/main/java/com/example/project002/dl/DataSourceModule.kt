package com.example.project002.dl

import androidx.room.Room
import com.example.project002.data.AppDatabase
import com.example.project002.data.dao.DoctorDao
import com.example.project002.data.dao.ServiceDao
import com.example.project002.data.datasources.MemoryDataSource
import com.example.project002.data.models.DoctorModel
import com.example.project002.data.repositories.HomeRepository
import com.example.project002.data.repositories.LoginRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataSourceModule = module{
    single {MemoryDataSource()}
    single <AppDatabase>{
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "dbGruponueve").build()
    }
    single <DoctorDao>{
        get<AppDatabase>().doctorDao()
    }
    single <ServiceDao>{
        get<AppDatabase>().serviceDao()
    }
}