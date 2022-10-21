package com.adgif.timofiytestapp.ui.view.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.adgif.timofiytestapp.R
import com.adgif.timofiytestapp.ui.model.GifUIModel
import com.bumptech.glide.Glide

class MainViewHolder(parentView: View) : RecyclerView.ViewHolder(parentView) {

    private val ivGif = parentView.findViewById<ImageView>(R.id.ivGif)

    fun onBind(model: GifUIModel) {
        Glide.with(ivGif.context)
            .load(model.images.ogImage.url)
            .into(ivGif)
    }

}