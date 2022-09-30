package com.example.project002.data.viewmodels

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project002.data.models.UserModel
import com.example.project002.data.repositories.LoginRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(private val repo: LoginRepository): ViewModel() {
    private var _login: MutableLiveData<Boolean> = MutableLiveData()
    val login: LiveData<Boolean> get() = _login

    private val _user: MutableLiveData<UserModel> = MutableLiveData()
    val user: LiveData<UserModel> get() = _user

    fun login(email: String, password: String){

            viewModelScope.launch {
                try {
                repo.login(email, password)
                _login.postValue(true)
                }catch (e:Exception){
                    _login.postValue(false)
            }
        }
    }
    fun currentUser(){
        viewModelScope.launch {
            _user.postValue(repo.getCurrentUser())
        }
    }

    }

