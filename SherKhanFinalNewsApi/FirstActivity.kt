package com.example.SherKhanFinalNewsApi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinvolleynewsapi.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        fetch_news_button.setOnClickListener{
            val intent = Intent(this, NewsListActivity::class.java)


            startActivity(intent)
        }
    }
}
