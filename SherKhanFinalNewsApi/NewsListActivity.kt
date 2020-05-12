package com.example.SherKhanFinalNewsApi

import Articles
import NewsModel
import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.kotlinvolleynewsapi.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class NewsListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        VolleySingletion.initConfi(this)
        setContentView(R.layout.activity_main)
        sendRequest()

    }

    fun sendRequest() {
        ProgressBar1?.visibility = View.VISIBLE;

        val request = StringRequest(HttpConstants.BASE_URL, Response.Listener<String> { response ->
            var newsModel = Gson().fromJson(response, NewsModel::class.java)
            var newsList: List<Articles> = newsModel.articles!!
            listView1?.adapter =
                ListViewAdapter(newsList, this);





            ProgressBar1?.visibility = View.GONE;
        }, Response.ErrorListener { error ->
            loadToast(error.message)
            ProgressBar1?.visibility = View.GONE;
        })
//
        VolleySingletion.requestQueque.add(request)


        listView1.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as Articles

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("author", selectedItem.author)
            intent.putExtra("description", selectedItem.description)
            intent.putExtra("image", selectedItem.urlToImage)
            intent.putExtra("title", selectedItem.title)

            startActivity(intent)
        }


    }


    fun loadToast(content: String?) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }
}


