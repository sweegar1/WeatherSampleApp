package com.data.weatherforecast.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.data.weatherforecast.data.repository.MainRepository
import com.data.weatherforecast.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
//    var data = MutableLiveData<Results?>()

    fun getWeatherData() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getWeatherData()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Exception Occured!!"))
        }

    }

//    fun addArticalDetailsFragment(result: Results) {
//        data.value = result
//        data.postValue(null)
//    }

}