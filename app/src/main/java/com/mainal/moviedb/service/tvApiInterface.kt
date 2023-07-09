package com.mainal.moviedb.service

import com.mainal.moviedb.model.tvresponse
import retrofit2.Call
import retrofit2.http.GET

interface tvApiInterface {
    @GET("/3/tv/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getTVList(): Call<tvresponse>

}