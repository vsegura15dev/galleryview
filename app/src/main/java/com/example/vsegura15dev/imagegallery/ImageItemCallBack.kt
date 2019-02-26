package com.example.vsegura15dev.imagegallery

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View

class ImageItemCallBack(var context: Context, var recyclerView: RecyclerView, var position: Int) :
    ActionMode.Callback {


    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {

        return when (item?.itemId) {

            R.id.delete -> {
                unCheck()
                val adapter = (recyclerView.adapter as ImageGalleryAdapter)
                adapter.removeItem(position)
                mode?.finish()
                adapter.notifyDataSetChanged()
                true
            }
            else -> false
        }

    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        val inflater = mode?.menuInflater
        inflater?.inflate(R.menu.image_actions, menu)
        return true

    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean = false

    override fun onDestroyActionMode(mode: ActionMode?) {
        unCheck()
    }

    private fun unCheck() {
        val viewHolder =
            (recyclerView.findViewHolderForAdapterPosition(position) as? ImageGalleryAdapter.ImageItemViewHolder)
        (viewHolder?.imageView?.parent as? View)?.isSelected =
                false
    }
}