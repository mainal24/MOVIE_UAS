package com.mainal.moviedb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mainal.moviedb.model.MovieResponse
import com.mainal.moviedb.model.movie
import com.mainal.moviedb.service.MovieApiInterface
import com.mainal.moviedb.service.MovieApiService
import kotlinx.android.synthetic.main.fragment_movie.rv_television
import retrofit2.Call
import retrofit2.Callback


class MovieFragment : Fragment() {
    private val movies = arrayListOf<movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_television.layoutManager = LinearLayoutManager(this.context)
        rv_television.setHasFixedSize(true)
        getMovieData { movies : List<movie> ->
            rv_television.adapter = movieadapter(movies)
        }
        showRecyclerView()
    }

    private fun getMovieData(callback: (List<movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: retrofit2.Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }

    private fun showRecyclerView() {
        rv_television.layoutManager = LinearLayoutManager(this.context)
        rv_television.adapter = movieadapter(movies)
    }
}