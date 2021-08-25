package com.cagataymuhammet.itunesapi.ui.search.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.cagataymuhammet.itunesapi.R
import com.cagataymuhammet.itunesapi.data.model.SearchResult
import com.cagataymuhammet.itunesapi.databinding.FragmentDetailBinding
import com.cagataymuhammet.itunesapi.ui.base.BaseBindingFragment
import com.cagataymuhammet.itunesapi.ui.search.SearchActivity
import com.cagataymuhammet.itunesapi.util.extentions.getFormattedDate
import com.cagataymuhammet.itunesapi.util.extentions.getFormattedPrice
import com.cagataymuhammet.itunesapi.util.extentions.loadFromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseBindingFragment<FragmentDetailBinding>() {

    override fun getContentLayoutResId()=R.layout.fragment_detail

    override fun populateUI() {

            arguments?.apply {
                val argumentItem: SearchResult? = DetailFragmentArgs.fromBundle(this).searchResultArgument
                mBinding?.apply {

                    poster.loadFromUrl(argumentItem?.artworkUrl100)
                    collectionName.text =argumentItem?.collectionName
                    collectionPrice.text = argumentItem?.collectionPrice.toString().getFormattedPrice(requireContext())
                    releaseDate.text = argumentItem?.releaseDate.getFormattedDate(requireContext())
                }
            }
    }
}