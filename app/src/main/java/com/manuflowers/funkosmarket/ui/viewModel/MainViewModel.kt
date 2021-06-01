package com.manuflowers.funkosmarket.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manuflowers.funkosmarket.data.model.FunkoEntity
import com.manuflowers.funkosmarket.data.repository.FunkosRepository

class MainViewModel(
    private val repository: FunkosRepository
) :ViewModel(){

    private val funkosListMutableLiveData =  MutableLiveData<List<FunkoEntity>>()
    val funkosListLiveData: LiveData<List<FunkoEntity>>
    get() = funkosListMutableLiveData

    fun loadData() {
        funkosListMutableLiveData.postValue(repository.getFunkosList())
    }
}