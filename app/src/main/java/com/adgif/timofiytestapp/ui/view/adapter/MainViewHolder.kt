package com.adgif.timofiytestapp.ui.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adgif.timofiytestapp.R

class MainViewHolder(parentView: View): RecyclerView.ViewHolder(parentView) {

    fun onBind(model: String){
        itemView.findViewById<TextView>(R.id.textView).text = model
    }

}