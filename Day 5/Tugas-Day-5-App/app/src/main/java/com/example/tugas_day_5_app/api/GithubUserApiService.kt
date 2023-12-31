package com.example.tugas_day_5_app.api

import com.example.tugas_day_5_app.model.DetailUserGithubModel
import com.example.tugas_day_5_app.model.UserGithubModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUserApiService {
    @GET("users")
    fun getListUsers(): Call<List<UserGithubModel>>

    @GET("users/{username}")
    fun getDetailUser(@Path("username") username: String): Call<DetailUserGithubModel>

    @GET("users/{username}/followers")
    fun getUserFollowersList(@Path("username") username: String): Call<List<UserGithubModel>>

    @GET("users/{username}/following")
    fun getUserFollowingList(@Path("username") username: String): Call<List<UserGithubModel>>
}