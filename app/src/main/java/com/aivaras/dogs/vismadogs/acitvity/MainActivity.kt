package com.aivaras.dogs.vismadogs.acitvity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import com.aivaras.dogs.vismadogs.R
import com.aivaras.dogs.vismadogs.adapter.ImageAdapter
import com.aivaras.dogs.vismadogs.utils.DogsJsonParser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dogUrls = DogsJsonParser.parse(this)

        // https://developer.android.com/guide/topics/ui/layout/gridview
        gridview.adapter = ImageAdapter(this, dogUrls.urls)

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            val url = dogUrls.urls[position]
            startActivity(FullImageActivity.createIntent(this, url))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}


