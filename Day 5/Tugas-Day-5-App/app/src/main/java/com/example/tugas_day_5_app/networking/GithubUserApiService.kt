package com.example.tugas_day_5_app.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUserApiService {
    @GET("users")
    fun getListUsers() : Call<List<UserGithubModel>>

    @GET("users/{username}")
    fun getDetailUser(@Path("username") username : String) : Call<UserGithubModel>
}