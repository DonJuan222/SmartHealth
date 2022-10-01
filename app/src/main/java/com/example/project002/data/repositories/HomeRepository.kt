package com.example.project002.data.repositories

import com.example.project002.data.dao.DoctorDao
import com.example.project002.data.dao.ServiceDao
import com.example.project002.data.datasources.MemoryDataSource
import com.example.project002.data.models.CompanyModel
import com.example.project002.data.models.DoctorModel
import com.example.project002.data.models.ServiceModel

class HomeRepository(private val memoryDataSource: MemoryDataSource,
    private val serviceDao: ServiceDao, private val doctorDao: DoctorDao) {

    suspend fun getServices():List<ServiceModel>{
//        return memoryDataSource.getServices()
        return serviceDao.getAll()
    }
    suspend fun getInfo():CompanyModel{
        return memoryDataSource.getInfo()
    }
    suspend fun getSpecialist(category: String?): List<DoctorModel>{
//        return memoryDataSource.getSpecialist(category)
        if (category == null) return doctorDao.getAll()
        return doctorDao.getAllBySpeciality(category)
    }
}