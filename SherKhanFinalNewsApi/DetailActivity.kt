package com.example.SherKhanFinalNewsApi

import android.opengl.Visibility
import android.os.Bundle

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinvolleynewsapi.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.listview_items.view.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prograss_load_photo_det?.visibility = View.VISIBLE
        setContentView(R.layout.activity_detail)

        setTitle(intent?.getStringExtra("title") ?: "null");
        val intent = intent

        author.text = intent?.getStringExtra("author") ?: "null"
        desc.text = intent?.getStringExtra("description") ?: "null"
        title_t.text = intent?.getStringExtra("title") ?: "null"


        val picasso = Picasso.get()
        picasso.load(intent.getStringExtra("image")).into(img, object : Callback {
            override fun onSuccess() {
                prograss_load_photo_det?.visibility = View.GONE
            }

            override fun onError(e: Exception) {
                // image download error
            }
        });
    }
}
