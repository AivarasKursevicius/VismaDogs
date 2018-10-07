package com.aivaras.dogs.vismadogs.acitvity

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.aivaras.dogs.vismadogs.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_full_image.*


class FullImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

        val url = intent.getStringExtra(KEY_URL)

        // Load image by url
        fullImageProressBar.visibility = View.VISIBLE
        Glide.with(this)
                .load(url)
                .listener(object : RequestListener<Drawable> {
                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        fullImageProressBar.visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        return false
                    }
                })
                .into(fullDogImageView)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    companion object {

        private const val KEY_URL = "keyUrl"

        fun createIntent(context: Context, url: String) =
                Intent(context, FullImageActivity::class.java).apply {
                    putExtra(KEY_URL, url)
                }
    }
}
