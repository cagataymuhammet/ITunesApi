package com.cagataymuhammet.itunesapi.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResponse(

    @SerializedName("resultCount")
    val resultCount: Int?,

    @SerializedName("results")
    val results: ArrayList<SearchResult>
)

data class SearchResult(
    @SerializedName("artistId")
    val artistId: Int?,
    @SerializedName("artistName")
    val artistName: String?,
    @SerializedName("artistViewUrl")
    val artistViewUrl: String?,
    @SerializedName("artworkUrl100")
    val artworkUrl100: String?,
    @SerializedName("artworkUrl30")
    val artworkUrl30: String?,
    @SerializedName("artworkUrl60")
    val artworkUrl60: String?,
    @SerializedName("collectionExplicitness")
    val collectionExplicitness: String?,
    @SerializedName("collectionName")
    val collectionName: String?,
    @SerializedName("collectionPrice")
    val collectionPrice: Double?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?,
    @SerializedName("primaryGenreName")
    val primaryGenreName: String?,
    @SerializedName("releaseDate")
    val releaseDate: String?,
    @SerializedName("trackCensoredName")
    val trackCensoredName: String?,
    @SerializedName("trackExplicitness")
    val trackExplicitness: String?,
    @SerializedName("trackId")
    val trackId: Int?,
    @SerializedName("trackName")
    val trackName: String?,
    @SerializedName("trackPrice")
    val trackPrice: Double?,
    @SerializedName("trackTimeMillis")
    val trackTimeMillis: Int?,
    @SerializedName("trackViewUrl")
    val trackViewUrl: String?,
    @SerializedName("wrapperType")
    val wrapperType: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(artistId)
        parcel.writeString(artistName)
        parcel.writeString(artistViewUrl)
        parcel.writeString(artworkUrl100)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeString(collectionExplicitness)
        parcel.writeString(collectionName)
        parcel.writeValue(collectionPrice)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeString(kind)
        parcel.writeString(previewUrl)
        parcel.writeString(primaryGenreName)
        parcel.writeString(releaseDate)
        parcel.writeString(trackCensoredName)
        parcel.writeString(trackExplicitness)
        parcel.writeValue(trackId)
        parcel.writeString(trackName)
        parcel.writeValue(trackPrice)
        parcel.writeValue(trackTimeMillis)
        parcel.writeString(trackViewUrl)
        parcel.writeString(wrapperType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchResult> {
        override fun createFromParcel(parcel: Parcel): SearchResult {
            return SearchResult(parcel)
        }

        override fun newArray(size: Int): Array<SearchResult?> {
            return arrayOfNulls(size)
        }
    }

}