package com.example.tugas_day_5_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_day_5_app.databinding.ActivityMainBinding

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
        val rvUserListAdapter = UserListAdapter()

        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        binding.rvUserList.adapter = rvUserListAdapter

        rvUserListAdapter.setUserList(userList)
    }
}