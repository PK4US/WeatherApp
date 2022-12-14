package com.pk4us.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pk4us.weatherapp.adapters.WeatherModel

class MainViewModel:ViewModel() {
    val liveDataCurrent  = MutableLiveData<WeatherModel>()
    val liveDataList  = MutableLiveData<List<WeatherModel>>()
}