package com.data.weatherforecast.data.repository

import com.data.weatherforecast.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getWeatherData() = apiHelper.getWeatherData()
}