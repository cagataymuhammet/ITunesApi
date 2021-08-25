package com.cagataymuhammet.itunesapi.util.extentions

import android.content.Context
import com.cagataymuhammet.itunesapi.R
import java.text.SimpleDateFormat
import java.util.*

fun String?.getFormattedDate(context: Context):String
{
    this?.apply {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
        val parsedDate = sdf.parse(this)
        val systemSdp = SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH)
        val formattedDate=systemSdp.format(parsedDate)
        val str=context.resources.getString(R.string.release)
        return "$str $formattedDate"
    }

    return  ""
}

fun String?.getFormattedPrice(context: Context):String
{
    this?.apply {
        val priceUnit=context.resources.getString(R.string.price_unit)
        return "$this $priceUnit"
    }

    return  ""
}