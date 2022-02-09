package com.data.weatherforecast.data.model

import com.google.gson.annotations.SerializedName


data class WeatherResponseModel(
    @SerializedName("cod") var cod: String? = null,
    @SerializedName("message") var message: Double? = null,
    @SerializedName("cnt") var cnt: Int? = null,
    @SerializedName("list") var list: ArrayList<List> = arrayListOf(),
    @SerializedName("city") var city: City? = City()
)

data class City(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("coord") var coord: Coord? = Coord(),
    @SerializedName("country") var country: String? = null
)

data class Clouds(
    @SerializedName("all") var all: Int? = null
)

data class Coord(

    @SerializedName("lat") var lat: Double? = null,
    @SerializedName("lon") var lon: Double? = null

)

data class List(

    @SerializedName("dt") var dt: Int? = null,
    @SerializedName("main") var main: Main? = Main(),
    @SerializedName("weather") var weather: ArrayList<Weather> = arrayListOf(),
    @SerializedName("clouds") var clouds: Clouds? = Clouds(),
    @SerializedName("wind") var wind: Wind? = Wind(),
    @SerializedName("snow") var snow: Snow? = Snow(),
    @SerializedName("sys") var sys: Sys? = Sys(),
    @SerializedName("dt_txt") var dtTxt: String? = null

)


data class Main(

    @SerializedName("temp") var temp: Double? = null,
    @SerializedName("temp_min") var tempMin: Double? = null,
    @SerializedName("temp_max") var tempMax: Double? = null,
    @SerializedName("pressure") var pressure: Double? = null,
    @SerializedName("sea_level") var seaLevel: Double? = null,
    @SerializedName("grnd_level") var grndLevel: Double? = null,
    @SerializedName("humidity") var humidity: Int? = null,
    @SerializedName("temp_kf") var tempKf: Double? = null

)

data class Snow(
    @SerializedName("string") var string: String? = null

)

data class Sys(

    @SerializedName("pod") var pod: String? = null

)

data class Weather(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("main") var main: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("icon") var icon: String? = null

)

data class Wind(

    @SerializedName("speed") var speed: Double? = null,
    @SerializedName("deg") var deg: Double? = null

)