package com.cagataymuhammet.itunesapi.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.cagataymuhammet.itunesapi.data.model.SearchResult

object Utils {

    val searchDiffUtil: DiffUtil.ItemCallback<SearchResult> =
        object : DiffUtil.ItemCallback<SearchResult>() {
            override fun areItemsTheSame(
                oldItem: SearchResult,
                newItem: SearchResult
            ): Boolean {
                return oldItem.trackId === newItem.trackId
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: SearchResult,
                newItem: SearchResult
            ): Boolean {
                return oldItem == newItem
            }
        }
}