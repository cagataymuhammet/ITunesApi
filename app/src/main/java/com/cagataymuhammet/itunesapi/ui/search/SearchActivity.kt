package com.cagataymuhammet.itunesapi.ui.search

import android.os.Bundle
import android.view.MenuItem
import com.cagataymuhammet.itunesapi.R
import com.cagataymuhammet.itunesapi.databinding.ActivitySearchBinding
import com.cagataymuhammet.itunesapi.ui.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchActivity : BaseBindingActivity<ActivitySearchBinding>() {

    override fun getContentViewLayoutResId(): Int {
        return R.layout.activity_search
    }

    override fun populateUI(savedInstanceState: Bundle?) {
         showUpButton()
    }

    fun showUpButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun hideUpButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}