package com.example.project002.data.datasources

import com.example.project002.R
import com.example.project002.data.models.ServiceModel

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
}