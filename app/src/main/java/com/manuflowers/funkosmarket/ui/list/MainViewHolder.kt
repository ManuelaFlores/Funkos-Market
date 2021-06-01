package com.manuflowers.funkosmarket.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.funkosmarket.R
import com.manuflowers.funkosmarket.data.model.FunkoEntity
import kotlinx.android.synthetic.main.main_view_holder.view.*

class MainViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {
    companion object {
        fun newInstance(parent: ViewGroup): MainViewHolder {
            return MainViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.main_view_holder, parent, false)
            )
        }
    }

    fun bind(funkoEntity: FunkoEntity) {

        itemView.mainImageView.setImageResource(
            itemView.context.resources.getIdentifier(
                funkoEntity.imageURL,
                null,
                itemView.context.packageName
            )
        )
        itemView.mainDescription.text = funkoEntity.description
        itemView.contentDescription = funkoEntity.description
    }
}