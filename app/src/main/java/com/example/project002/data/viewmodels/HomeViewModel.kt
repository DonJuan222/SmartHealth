package com.example.project002.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project002.data.models.ServiceModel
import com.example.project002.data.repositories.HomeRepository
import com.example.project002.dl.viewModelModule
import kotlinx.coroutines.launch

class HomeViewModel(private val repo: HomeRepository): ViewModel() {
    private var _services: MutableLiveData<List<ServiceModel>> = MutableLiveData()
    val services: LiveData<List<ServiceModel>> get() = _services

    fun getServices(){
        viewModelScope.launch {
            _services.postValue(repo.getServices())
        }
    }

}