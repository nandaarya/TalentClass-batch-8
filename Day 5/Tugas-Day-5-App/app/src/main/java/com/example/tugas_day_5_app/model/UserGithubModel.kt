package com.example.tugas_day_5_app.model

import com.google.gson.annotations.SerializedName

data class UserGithubModel(
    @SerializedName("login") val userName: String? = "",
    @SerializedName("avatar_url") val avatarURL: String? = "",
)
