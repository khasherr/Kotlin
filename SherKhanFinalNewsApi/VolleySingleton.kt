package com.example.SherKhanFinalNewsApi

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

object VolleySingletion{
    private lateinit var context: Context
    val requestQueque : RequestQueue by lazy {
        Volley.newRequestQueue(context)
    }

    fun initConfi(context:Context){
        VolleySingletion.context =context.applicationContext
    }
}