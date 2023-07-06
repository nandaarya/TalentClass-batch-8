package com.example.tugas_day_3_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_day_3_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUserList()
    }

    private fun setUserList() {
        val listNames = listOf(
            "Budi Santoso",
            "Rina Kartika",
            "Ahmad Hidayat",
            "Siti Aisyah",
            "Joko Prasetyo",
            "Dewi Rahayu",
            "Hendra Wijaya",
            "Linda Sari",
            "Eko Nugroho",
            "Dian Purnama"
        )

        val rvUserListAdapter = UserListAdapter()

        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        binding.rvUserList.adapter = rvUserListAdapter

        rvUserListAdapter.addListOfName(listNames)
    }
}