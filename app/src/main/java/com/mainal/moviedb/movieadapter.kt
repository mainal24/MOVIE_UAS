package com.mainal.moviedb

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mainal.moviedb.model.movie
import kotlinx.android.synthetic.main.movie_item.view.movie_overview
import kotlinx.android.synthetic.main.movie_item.view.movie_poster
import kotlinx.android.synthetic.main.movie_item.view.movie_title


class movieadapter (
    private val movies : List<movie>
) : RecyclerView.Adapter<movieadapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : movie){
            itemView.movie_title.text = movie.title
            itemView.movie_overview.text = movie.overview
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindMovie(movies.get(position))

        holder.itemView.setOnClickListener {
            moveToMoviesDetail(movie, it)
        }
    }

    private fun moveToMoviesDetail(movie: movie, it: View) {
        val detailMoviesIntent = Intent(it.context, moviedetailActivity::class.java)
        detailMoviesIntent.putExtra(moviedetailActivity.EXTRA_MOVIES, movie)
        it.context.startActivity(detailMoviesIntent)

    }
}
