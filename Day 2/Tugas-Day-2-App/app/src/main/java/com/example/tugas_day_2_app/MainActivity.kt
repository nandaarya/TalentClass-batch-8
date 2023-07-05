package com.example.tugas_day_2_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas_day_2_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSendData.setOnClickListener{
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val jurusan = binding.etJurusan.text.toString()
            val semester = binding.etSemester.text.toString()

            val intent = Intent(this, ShowDataActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("jurusan", jurusan)
            intent.putExtra("semester", semester)
            startActivity(intent)
        }
    }
}