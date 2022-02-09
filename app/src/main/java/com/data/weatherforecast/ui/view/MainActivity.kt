package com.data.weatherforecast.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.data.weatherforecast.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addWeatherListFragment()
    }

   private fun addWeatherListFragment() {
        this.supportFragmentManager.beginTransaction()
            .add(R.id.container, WeatherListFragment.newInstance()).commit()
    }
}