package com.data.weatherforecast.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.data.weatherforecast.R
import com.data.weatherforecast.data.model.List
import com.data.weatherforecast.databinding.ItemViewBinding
import com.data.weatherforecast.ui.viewmodel.MainViewModel
import java.util.ArrayList

class WeatherListRecyclerAdapter(
    val viewModel: MainViewModel,
    val arrayDetails: ArrayList<List>,
    val context: Context
): RecyclerView.Adapter<WeatherListRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(arrayDetails[position]) {
                binding.title.text = arrayDetails[position].dtTxt
                binding.content.text = arrayDetails[position].dt.toString()

                binding.card.setOnClickListener {
//                    viewModel.addArticalDetailsFragment(arrayDetails[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        if (arrayDetails.size == 0) {
            Toast.makeText(context, context.getString(R.string.empty_list), Toast.LENGTH_LONG).show()
        } else {

        }
        return arrayDetails.size
    }

    inner class ViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

}