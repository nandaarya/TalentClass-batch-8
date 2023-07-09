package com.example.tugas_day_5_app

data class UserData(
    val photoProfile: String,
    val username: String,
    val name: String,
    val email: String,
    val company: String
)

val userList = listOf(
    UserData(
        "https://st.depositphotos.com/2931363/5142/i/450/depositphotos_51425493-stock-photo-student-holding-textbooks.jpg",
        "Nandaarya",
        "Nanda Arya Putra",
        "nanda@gmail.com",
        "Talent Hub"
    ),
    UserData(
        "https://st4.depositphotos.com/2760050/38295/i/450/depositphotos_382951958-stock-photo-library-makes-you-visionary-library.jpg",
        "rinawati",
        "rina wati",
        "rina@gmail.com",
        "Talent Hub"
    )
)