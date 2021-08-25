package com.cagataymuhammet.itunesapi.ui.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.cagataymuhammet.itunesapi.ITunesApp
import com.cagataymuhammet.itunesapi.ui.BaseBindingActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun getContentViewLayoutResId(): Int

    @Inject
    @ApplicationContext
    lateinit var appContext: Context

    lateinit var iTunesApp: ITunesApp

    abstract fun populateUI(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iTunesApp = appContext as ITunesApp

        if (this !is BaseBindingActivity<*>) {
            setContentView(getContentViewLayoutResId())
            populateUI(savedInstanceState)
        }
    }

}

