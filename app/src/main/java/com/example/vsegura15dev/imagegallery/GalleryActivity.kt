package com.example.vsegura15dev.imagegallery

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        configureRecyclerView()

    }

    private fun configureRecyclerView() {


        val adapter = ImageGalleryAdapter(getSampleImageIds())
        imageGalleryRecyclerView.adapter = adapter

        imageGalleryRecyclerView.layoutManager = getLayoutManager(getSpanCount())
    }

    private fun getSpanCount(): Int {

        val deviceType = imageGalleryRecyclerView.tag
        return if (deviceType == "tablet") getSpanCountForTablet() else getSpanCountForHandset()

    }

    private fun getSpanCountForHandset(): Int =
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 2

    private fun getSpanCountForTablet(): Int =
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 5 else 3


    private fun getLayoutManager(spanCount: Int): GridLayoutManager =
        GridLayoutManager(this, spanCount, GridLayoutManager.VERTICAL, false)


    private fun getSampleImageIds(): MutableList<Int> = mutableListOf(
        R.drawable.sample_0, R.drawable.sample_1
        , R.drawable.sample_2, R.drawable.sample_3
        , R.drawable.sample_4, R.drawable.sample_5
        , R.drawable.sample_6, R.drawable.sample_7
    )


}
