package com.sachin.weathear.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sachin.weathear.R
import com.sachin.weathear.databinding.RawUserBinding
import com.sachin.weathear.rest.vo.ForecastData
import com.sachin.weathear.rest.vo.Main
import kotlinx.android.synthetic.main.raw_user.view.*
import java.text.SimpleDateFormat
import java.util.*

class UserAdapter(val adapterClick: (Any) -> Unit) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var data: ForecastData
    var myList: ArrayList<String> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RawUserBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.raw_user, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::data.isInitialized) myList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data.list[position].main)
        holder.itemView.ivThumb.setOnClickListener {
//            adapterClick(
//                data[holder.itemView.ivThumb.tag.toString().toInt()].url
//            )
        }
    }

    class ViewHolder(private val binding: RawUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(datum: Main) {
            binding.viewModel = datum
            binding.ivThumb.tag = datum.pressure
        }
    }


    fun updateUserList(forecast: ForecastData) {
        this.data = forecast
        notifyDataSetChanged()
    }

    fun toSimpleString(date: String) : String {
        val format = SimpleDateFormat("dd/MM/yyy")
        return format.format(date)
    }
}