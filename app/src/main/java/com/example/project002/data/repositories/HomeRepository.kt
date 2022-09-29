package com.example.project002.data.repositories

import com.example.project002.data.datasources.MemoryDataSource
import com.example.project002.data.models.ServiceModel

class HomeRepository(private val memoryDataSource: MemoryDataSource) {

    suspend fun getServices():List<ServiceModel>{
        return memoryDataSource.getServices()
    }
}