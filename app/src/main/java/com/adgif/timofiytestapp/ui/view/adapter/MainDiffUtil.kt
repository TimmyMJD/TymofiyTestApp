package com.adgif.timofiytestapp.ui.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.adgif.timofiytestapp.ui.model.GifUIModel

class MainDiffUtil : DiffUtil.ItemCallback<GifUIModel>() {
    override fun areItemsTheSame(oldItem: GifUIModel, newItem: GifUIModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GifUIModel, newItem: GifUIModel): Boolean {
        return oldItem == newItem
    }
}