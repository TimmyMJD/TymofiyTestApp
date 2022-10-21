package com.adgif.timofiytestapp.ui.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adgif.timofiytestapp.R
import com.adgif.timofiytestapp.ui.model.GifUIModel

class MainViewHolder(parentView: View): RecyclerView.ViewHolder(parentView) {

    private val ivGif = parentView.findViewById<ImageView>(R.id.ivGif)

    fun onBind(model: GifUIModel){

        ivGif.context
    }

}