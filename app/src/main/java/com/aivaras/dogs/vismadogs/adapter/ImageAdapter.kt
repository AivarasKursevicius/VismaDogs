package com.aivaras.dogs.vismadogs.adapter

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.aivaras.dogs.vismadogs.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


class ImageAdapter(private val context: Context, private val urls: Array<String>) : BaseAdapter() {

    override fun getCount(): Int = urls.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: View
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = LayoutInflater.from(context).inflate(R.layout.item_image, null)
        } else {
            imageView = convertView
        }

        // Load image by url
        imageView.findViewById<ProgressBar>(R.id.dogImageProgressBar).visibility = View.VISIBLE
        Glide.with(context).load(urls[position])
                .listener(object : RequestListener<Drawable> {
                    override fun onResourceReady(resource: Drawable?, model: Any?,
                                                 target: Target<Drawable>?,
                                                 dataSource: DataSource?,
                                                 isFirstResource: Boolean): Boolean {
                        imageView.findViewById<ProgressBar>(R.id.dogImageProgressBar).visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(e: GlideException?, model: Any?,
                                              target: com.bumptech.glide.request.target.Target<Drawable>?,
                                              isFirstResource: Boolean): Boolean {
                        return false
                    }
                })
                .into(imageView.findViewById(R.id.dogImageView) as ImageView)

        // Set static row height to avoid overlapping
        imageView.setLayoutParams(AbsListView.LayoutParams(GridView.AUTO_FIT, dpToPx(100)))

        return imageView
    }

    private fun dpToPx(pixels: Int) = (pixels * Resources.getSystem().displayMetrics.density).toInt()
}