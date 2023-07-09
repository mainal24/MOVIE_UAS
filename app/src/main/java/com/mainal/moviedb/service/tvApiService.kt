package com.mainal.moviedb.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class tvApiService {

    companion object {
        fun getInstance(): Any {
            TODO("Not yet implemented")
        }
    }

    val  BASE_URL = "https://www.api.themoviedb.org"

    private var retrofit : Retrofit? = null

    fun getInstance(): Retrofit {
        if(retrofit ==  null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}
