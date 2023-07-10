package com.example.tugas_day_5_app.networking

import com.google.gson.annotations.SerializedName

data class DetailUserGithubModel(
    @SerializedName("avatar_url") val avatarURL: String? = "",
    @SerializedName("login") val userName: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("email") val email: String? = "",
    @SerializedName("company") val company: String? = "",
)
