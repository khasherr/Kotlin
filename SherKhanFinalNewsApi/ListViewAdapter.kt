package com.example.SherKhanFinalNewsApi

import Articles
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kotlinvolleynewsapi.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.listview_items.view.*


class ListViewAdapter(
    listValue: List<Articles>,
    var context: Context
) :
    BaseAdapter() {

    val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var TempSubjectList: List<Articles>
    override fun getCount(): Int {
        return TempSubjectList.size
    }

    override fun getItem(position: Int): Any {
        return TempSubjectList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.listview_items, parent, false)

        val article = getItem(position) as Articles
        rowView.author1.text=article.author

        //rowView.publishedAt.text=article.publishedAt
        rowView.desc1.text=article.description
        rowView.title1.text=article.title


        val picasso = Picasso.get()
        picasso.load(article.urlToImage).into(rowView.img1,object : Callback {
            override fun onSuccess() {

                rowView.progress_load_photo.visibility= View.GONE;
            }


            override fun onError(e: Exception) {
                // image download error
            }
        });

        return rowView
    }


      init {
        TempSubjectList = listValue
    }
}

internal class ViewItem {
    var IdTextView: TextView? = null
    var NameTextView: TextView? = null
}
