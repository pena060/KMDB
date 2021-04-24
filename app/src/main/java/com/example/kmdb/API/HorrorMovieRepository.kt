package com.example.kmdb.API

import android.util.Log
import com.example.kmdb.models.Movie
import com.example.kmdb.models.MovieQueryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object HorrorMovieRepository {

    private val makeQueryToTMDB: MakeQueryToTMDB

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        makeQueryToTMDB = retrofit.create(MakeQueryToTMDB::class.java)
    }

    //get now playing movies from repository
    fun getNowPlayingMovies(page: Int = 1,
                            onSuccess: (movies: List<Movie>) -> Unit,
                            onError: () -> Unit){

        makeQueryToTMDB.getNowPlayingMovies(page = page)
            .enqueue(object : Callback<MovieQueryResponse> {
                override fun onResponse(
                    call: Call<MovieQueryResponse>,
                    response: Response<MovieQueryResponse>
                ) {
                    if (response.isSuccessful){
                        val responseBody = response.body()

                        if(responseBody != null){
                            onSuccess.invoke(responseBody.movies)
                        }else{
                            onError.invoke()
                        }
                    }else{
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MovieQueryResponse>, t: Throwable) {
                    onError.invoke()

                }

            })
    }

    //get now playing movies from repository
    fun getUpcomingMovies(page: Int = 1,
                            onSuccess: (movies: List<Movie>) -> Unit,
                            onError: () -> Unit){

        makeQueryToTMDB.getUpcomingMovies(page = page)
                .enqueue(object : Callback<MovieQueryResponse> {
                    override fun onResponse(
                            call: Call<MovieQueryResponse>,
                            response: Response<MovieQueryResponse>
                    ) {
                        if (response.isSuccessful){
                            val responseBody = response.body()

                            if(responseBody != null){
                                onSuccess.invoke(responseBody.movies)
                            }else{
                                onError.invoke()
                            }
                        }else{
                            onError.invoke()
                        }
                    }

                    override fun onFailure(call: Call<MovieQueryResponse>, t: Throwable) {
                        onError.invoke()

                    }

                })
    }

    //get popular movies from repository
    fun getPopularMovies(page: Int = 1,
                          onSuccess: (movies: List<Movie>) -> Unit,
                          onError: () -> Unit){

        makeQueryToTMDB.getPopularMovies(page = page)
                .enqueue(object : Callback<MovieQueryResponse> {
                    override fun onResponse(
                            call: Call<MovieQueryResponse>,
                            response: Response<MovieQueryResponse>
                    ) {
                        if (response.isSuccessful){
                            val responseBody = response.body()

                            if(responseBody != null){
                                onSuccess.invoke(responseBody.movies)
                            }else{
                                onError.invoke()
                            }
                        }else{
                            onError.invoke()
                        }
                    }

                    override fun onFailure(call: Call<MovieQueryResponse>, t: Throwable) {
                        onError.invoke()

                    }

                })
    }

    //get top rated movies from repository
    fun getTopRatedMovies(page: Int = 1,
                            onSuccess: (movies: List<Movie>) -> Unit,
                            onError: () -> Unit){

        makeQueryToTMDB.getTopRatedMovies(page = page)
                .enqueue(object : Callback<MovieQueryResponse> {
                    override fun onResponse(
                            call: Call<MovieQueryResponse>,
                            response: Response<MovieQueryResponse>
                    ) {
                        if (response.isSuccessful){
                            val responseBody = response.body()

                            if(responseBody != null){
                                onSuccess.invoke(responseBody.movies)
                            }else{
                                onError.invoke()
                            }
                        }else{
                            onError.invoke()
                        }
                    }

                    override fun onFailure(call: Call<MovieQueryResponse>, t: Throwable) {
                        onError.invoke()

                    }

                })
    }
}