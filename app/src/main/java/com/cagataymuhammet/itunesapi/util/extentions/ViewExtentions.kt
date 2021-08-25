package com.cagataymuhammet.itunesapi.util.extentions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadFromUrl(url: String?){

    url?.let {
        Glide.with(this.context)
            .load(url)
            // .error(R.drawable.interneticon)
            .centerCrop()
            .into(this)
    }

}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}