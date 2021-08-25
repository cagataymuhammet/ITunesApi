package com.cagataymuhammet.itunesapi.util.constants

import com.cagataymuhammet.itunesapi.data.model.EntitiyModel
import com.cagataymuhammet.itunesapi.data.model.SearchResult
import com.google.gson.annotations.SerializedName



enum class EntitiyType(val value: EntitiyModel) {
    ALL(EntitiyModel("All","")),
    MUSIC_VIDEO(EntitiyModel("Music","musicVideo")),
    MOVIE(EntitiyModel("Movies","movie")),
    EBOOK(EntitiyModel("Ebook","podcast")),
    PODCAST(EntitiyModel("Podcast","podcast"));

    companion object {
        fun findEnumTypeByText(text: CharSequence): EntitiyType? {

            values().find{  it.value.name ==text }?.let {
                return it
            }

            return null
        }
    }
}
