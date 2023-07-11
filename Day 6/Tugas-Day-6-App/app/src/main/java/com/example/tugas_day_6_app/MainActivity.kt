package com.example.tugas_day_6_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas_day_6_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setFAB()
    }

    private fun setFAB() {
        binding.fabAddBook.setOnClickListener{
            val intent = Intent(this, AddBookActivity::class.java)
            startActivity(intent)
        }
    }
}