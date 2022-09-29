package com.example.project002.data.repositories

import kotlinx.coroutines.delay

class LoginRepository {
    suspend fun login(email: String, password: String){
        delay(2000)
        if (email != "jpolindaratrujillo@gmail.com" || password != "123456789"){
            throw Exception("Credenciales invalidas")
        }
    }
}