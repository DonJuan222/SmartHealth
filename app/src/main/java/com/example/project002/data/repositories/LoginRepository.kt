package com.example.project002.data.repositories

import com.example.project002.data.datasources.MemoryDataSource
import com.example.project002.data.models.UserModel
import com.example.project002.util.USER_COLLETION
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await

class LoginRepository (private val memoryDataSource: MemoryDataSource,
    private val authService: FirebaseAuth, private val db: FirebaseFirestore){
    suspend fun login(email: String, password: String){
        try {
            authService.signInWithEmailAndPassword(email, password).await()

        }catch (e: FirebaseAuthException){
            throw Exception(e.message)
        }
    }

    suspend fun logOut(){
        authService.signOut()

    }

    suspend fun getCurrentUser():UserModel?{
        val user = authService.currentUser
        if (user != null){
            var photo: String? = null
            if(user.photoUrl != null){
                photo = user.photoUrl.toString()
            }
            return UserModel(user.uid,user.displayName!!,user.email!!, "",photo)
        }
        return null
    }

    suspend fun signUp(email: String, password: String, name: String, gender:String){
        try {
            authService.createUserWithEmailAndPassword(email, password).await()
            val user = authService.currentUser!!
            val profileUpdate = userProfileChangeRequest {
                displayName = name
            }
            user.updateProfile(profileUpdate).await()
            val userInfo = hashMapOf(
                "gender" to gender
            )

            user.updateProfile(profileUpdate).await()
            db.collection(USER_COLLETION).document(user.uid).set(userInfo).await()

        }catch (e:FirebaseAuthException){
            throw Exception(e.message)
        }

    }
}