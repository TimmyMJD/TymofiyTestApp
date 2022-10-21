package com.adgif.timofiytestapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.adgif.timofiytestapp.R
import com.adgif.timofiytestapp.ui.model.GifUIModel
import javax.inject.Inject
import javax.inject.Singleton

class MainAdapter @Inject constructor(): ListAdapter<GifUIModel, MainViewHolder>(MainDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}