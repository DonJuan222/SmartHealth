package com.example.project002.data.datasources

import com.example.project002.R
import com.example.project002.data.models.CompanyModel
import com.example.project002.data.models.ServiceModel
import com.example.project002.data.models.UserModel

class MemoryDataSource {
    suspend fun getServices(): List<ServiceModel> {
        return listOf(
            ServiceModel(
                "1","General","Los mejores especialistas en Medicina General",
                R.drawable.ico_general.toString()
            ),
            ServiceModel(
                "2","Especialidades","Los mejores medicos Especialistas",
                R.drawable.ico_especialidades.toString()
            ),
            ServiceModel(
                "3","Odontologia","Los mejores especialistas en Odontologia",
                R.drawable.ico_odontologia.toString()
            ),
            ServiceModel(
                "4","Dermatologia","Los mejores especialistas en Dermatologia",
                R.drawable.ico_dermatologia.toString()
            )
        )
    }
    suspend fun getInfo():CompanyModel{
        return CompanyModel(
            "1",
            "Hola",
            3.0178418,-76.4820921
        )

    }

    suspend fun getCurrentUser():UserModel{
        return UserModel(
            "1",
            "Pepito Perez",
            "pepitoperez@gmail.com",
            "Masculino",
            null
        )

    }
}