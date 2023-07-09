package com.mainal.moviedb

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mainal.moviedb.model.tv
import kotlinx.android.synthetic.main.tv_item.view.tv_overview
import kotlinx.android.synthetic.main.tv_item.view.tv_poster
import kotlinx.android.synthetic.main.tv_item.view.tv_title

class tvadapter(
    private val tvs : List<tv>
) : RecyclerView.Adapter<tvadapter.TVViewHolder>() {

    class TVViewHolder (view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindTV(tv: tv){
            itemView.tv_title.text = tv.title
            itemView.tv_overview.text = tv.overview
            Glide.with(itemView).load(IMAGE_BASE + tv.poster).into(itemView.tv_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tvadapter.TVViewHolder {
        return tvadapter.TVViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tv_item, parent, false)
        )
    }

    override fun getItemCount(): Int = tvs.size

    override fun onBindViewHolder(holder: tvadapter.TVViewHolder, position: Int) {
        val tv = tvs[position]
        holder.bindTV(tvs.get(position))

        holder.itemView.setOnClickListener {
            moveToTvSDetail(tv, it)
        }
    }

    private fun moveToTvSDetail(tv: tv, it: View) {
        val detailTvsIntent = Intent(it.context, tvdetailActivity::class.java)
        detailTvsIntent.putExtra(tvdetailActivity.EXTRA_TvS, tv)
        it.context.startActivity(detailTvsIntent)

    }
}