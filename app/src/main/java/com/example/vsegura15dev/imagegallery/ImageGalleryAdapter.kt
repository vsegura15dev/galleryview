package com.example.vsegura15dev.imagegallery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ImageGalleryAdapter(var itemsId: MutableList<Int> = mutableListOf()) :
    RecyclerView.Adapter<ImageGalleryAdapter.ImageItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ImageItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageItemViewHolder(view)
    }

    override fun getItemCount(): Int = itemsId.count()

    override fun onBindViewHolder(viewHolder: ImageItemViewHolder, position: Int) {
        viewHolder.imageView.setImageResource(itemsId[position])
    }

    class ImageItemViewHolder : RecyclerView.ViewHolder {

        var imageView: ImageView

        constructor(itemView: View) : super(itemView) {

            this.imageView = itemView.findViewById(R.id.imageItemView)
        }
    }
}