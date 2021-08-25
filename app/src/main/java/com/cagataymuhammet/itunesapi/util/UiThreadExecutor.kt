package com.cagataymuhammet.itunesapi.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class UiThreadExecutor: Executor {
    private val handler = Handler (Looper.getMainLooper ())
    override fun execute (command: Runnable) {
        handler.post (command)
    }
}