package com.data.weatherforecast.data.api

import com.data.weatherforecast.utils.AppConstants


class ApiHelper(private val apiService: ApiService) {
    suspend fun getWeatherData() = apiService.getWeatherData(
        AppConstants.ACCESS_KEY,
        AppConstants.ID
    )

}