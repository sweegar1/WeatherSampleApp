package com.data.weatherforecast.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.data.weatherforecast.R
import com.data.weatherforecast.data.api.ApiHelper
import com.data.weatherforecast.data.api.RetrofitBuilder
import com.data.weatherforecast.ui.adapter.WeatherListRecyclerAdapter
import com.data.weatherforecast.ui.viewmodel.MainViewModel
import com.data.weatherforecast.ui.viewmodel.MainViewModelFactory
import com.data.weatherforecast.utils.GenericUtil
import com.data.weatherforecast.utils.Status
import kotlinx.android.synthetic.main.fragment_weather_list.*


class WeatherListFragment : Fragment() {


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseAdapter()
        observeData()

    }

    private fun initialiseAdapter() {

        recycler.layoutManager = LinearLayoutManager(activity)
    }

    fun observeData() {
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(
                ApiHelper(RetrofitBuilder.apiService)
            )
        ).get(MainViewModel::class.java)

        if (GenericUtil.isNetworkAvailable(requireActivity())) {
            fetchWeatherdata()

        } else {
            progress_circular.visibility = View.GONE
            message.text = "Please Check Your Intenet Connection!!"
            message.visibility = View.VISIBLE
        }
//        viewModel.data.observe(getViewLifecycleOwner(), Observer {
//            it?.let {
////                addArticalDetailsFragment(it)
//            }
//        })

    }

    private fun fetchWeatherdata() {

        viewModel.getWeatherData().observe(viewLifecycleOwner,
        Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progress_circular.visibility = View.GONE
                    recycler.visibility = View.VISIBLE
                    it.data?.let {
                        recycler.adapter = activity?.let { it1 ->
                            WeatherListRecyclerAdapter(
                                viewModel,
                                it.list, it1.applicationContext
                            )
                        }
                        recycler
                            .adapter?.notifyDataSetChanged()
                    }
                }

                Status.LOADING -> {
                    progress_circular.visibility = View.VISIBLE
                }

                Status.ERROR -> {
                    progress_circular.visibility = View.GONE
                    message.text = it.message
                    message.visibility = View.VISIBLE
                }

            }

        })


    }


//    private fun addArticalDetailsFragment(result: Results) {
//        requireActivity().supportFragmentManager.beginTransaction()
//            .add(R.id.container, ArticalDetailsFragment.newInstance(result))
//            .addToBackStack(null)
//            .commit()
//    }

    companion object {
        @JvmStatic
        fun newInstance() = WeatherListFragment()
    }
}