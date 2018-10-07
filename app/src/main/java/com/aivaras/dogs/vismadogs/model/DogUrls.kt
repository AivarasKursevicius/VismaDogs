package com.aivaras.dogs.vismadogs.model

import java.util.*

data class DogUrls(val urls: Array<String>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DogUrls

        if (!Arrays.equals(urls, other.urls)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(urls)
    }
}