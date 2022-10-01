package com.example.project002.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project002.data.dao.DoctorDao
import com.example.project002.data.dao.ServiceDao
import com.example.project002.data.models.DoctorModel
import com.example.project002.data.models.ServiceModel

@Database(entities = [DoctorModel::class, ServiceModel::class ], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
    abstract fun doctorDao(): DoctorDao

}