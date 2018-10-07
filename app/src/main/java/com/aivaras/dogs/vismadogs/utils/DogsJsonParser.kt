package com.aivaras.dogs.vismadogs.utils

import android.content.Context
import com.aivaras.dogs.vismadogs.model.DogUrls
import com.google.gson.GsonBuilder

object DogsJsonParser {

    private val FILENAME = "dog_urls.json"

    fun parse(context: Context): DogUrls {
        val gson = GsonBuilder().create()
        val asset = context.assets.open(FILENAME)
        val dogUrls = gson.fromJson(asset.reader(), DogUrls::class.java)
        return dogUrls
    }
}