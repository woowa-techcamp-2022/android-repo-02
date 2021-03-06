package com.woowahan.repositorysearch.util

import android.graphics.Color

object ColorCreator {
    @JvmStatic
    fun create(): Int {
        val red = (Math.random() * 255).toInt()
        val green = (Math.random() * 255).toInt()
        val blue = (Math.random() * 255).toInt()
        return Color.rgb(red, green, blue)
    }
}
