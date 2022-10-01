package com.example.project002.dl

import androidx.room.Room
import com.example.project002.data.AppDatabase
import com.example.project002.data.dao.DoctorDao
import com.example.project002.data.dao.ServiceDao
import com.example.project002.data.datasources.MemoryDataSource
import com.example.project002.data.models.DoctorModel
import com.example.project002.data.repositories.HomeRepository
import com.example.project002.data.repositories.LoginRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
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
    single{
        Firebase.auth
    }
    single {
        Firebase.firestore
    }
    single {
        Firebase.storage("gs://grupo9-66eba.appspot.com")
    }
}