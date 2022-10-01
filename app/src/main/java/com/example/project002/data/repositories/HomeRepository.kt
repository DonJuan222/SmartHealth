package com.example.project002.data.repositories

import com.example.project002.data.datasources.MemoryDataSource
import com.example.project002.data.models.CompanyModel
import com.example.project002.data.models.DoctorModel
import com.example.project002.data.models.ServiceModel

class HomeRepository(private val memoryDataSource: MemoryDataSource) {

    suspend fun getServices():List<ServiceModel>{
        return memoryDataSource.getServices()
    }
    suspend fun getInfo():CompanyModel{
        return memoryDataSource.getInfo()
    }
    suspend fun getSpecialist(category: String?): List<DoctorModel>{
        return memoryDataSource.getSpecialist(category)
    }
}