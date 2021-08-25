package com.cagataymuhammet.itunesapi.ui.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment




abstract class BaseFragment : Fragment() {


    @LayoutRes
    protected abstract fun getContentLayoutResId(): Int

    protected abstract fun populateUI()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getContentLayoutResId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        populateUI()

    }
}