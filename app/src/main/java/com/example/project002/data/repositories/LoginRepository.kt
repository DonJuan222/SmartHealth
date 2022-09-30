package com.example.project002.data.repositories

import com.example.project002.data.datasources.MemoryDataSource
import com.example.project002.data.models.UserModel
import kotlinx.coroutines.delay

class LoginRepository (private val memoryDataSource: MemoryDataSource){
    suspend fun login(email: String, password: String){
        delay(2000)
        if (email != "jpolindaratrujillo@gmail.com" || password != "123456789"){
            throw Exception("Credenciales invalidas")
        }
    }
    suspend fun getCurrentUser():UserModel{
        return memoryDataSource.getCurrentUser()

    }
}