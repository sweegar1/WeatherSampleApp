package com.data.weatherforecast.data.api

import com.data.weatherforecast.data.model.WeatherResponseModel
import com.data.weatherforecast.utils.AppConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/forecast")
    suspend fun getWeatherData(
        @Query(AppConstants.PARAM_API_KEY) accessKey: String,
        @Query(AppConstants.PARAM_ID) id: String
    ): WeatherResponseModel



}
