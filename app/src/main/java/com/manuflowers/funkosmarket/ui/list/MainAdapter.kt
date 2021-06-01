package com.manuflowers.funkosmarket.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.funkosmarket.data.model.FunkoEntity

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private val data = mutableListOf<FunkoEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(list: List<FunkoEntity>) {
        this.data.clear()
        this.data.addAll(list)
    }
}