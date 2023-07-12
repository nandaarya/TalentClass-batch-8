package com.example.tugas_day_6_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas_day_6_app.databinding.ActivityEditDetailBookBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditDetailBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditDetailBookBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditDetailBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        settingFirebaseRealtimeDB()
    }

    private fun settingFirebaseRealtimeDB() {
        database = FirebaseDatabase.getInstance().getReference("Books")
    }
}