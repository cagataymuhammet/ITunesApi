package com.cagataymuhammet.itunesapi.ui.search.search


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cagataymuhammet.itunesapi.data.model.SearchResult
import com.cagataymuhammet.itunesapi.databinding.ItemSearchBinding
import com.cagataymuhammet.itunesapi.util.Utils
import com.cagataymuhammet.itunesapi.util.extentions.getFormattedDate
import com.cagataymuhammet.itunesapi.util.extentions.getFormattedPrice
import com.cagataymuhammet.itunesapi.util.extentions.loadFromUrl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchPaggedListAdapter @Inject constructor(val appContext: Context) : PagedListAdapter<SearchResult, SearchPaggedListAdapter.ViewHolder?>(
    Utils.searchDiffUtil) {

    private var onItemClickListener: ((SearchResult) -> Unit)? = null

    fun setOnItemClickListener(listener: (SearchResult) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder constructor( val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(searchResult: SearchResult) {
            binding.collectionName.text = searchResult.collectionName
            binding.collectionPrice.text = searchResult.collectionPrice.toString().getFormattedPrice(appContext)
            binding.releaseDate.text = searchResult.releaseDate.getFormattedDate(appContext)

            binding.poster.loadFromUrl(searchResult.artworkUrl100)

            binding.item.setOnClickListener{
                onItemClickListener?.let {
                    it(searchResult)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item!!)
    }

}