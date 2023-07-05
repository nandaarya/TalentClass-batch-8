package com.example.tugas_day_2_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas_day_2_app.databinding.ActivityShowDataBinding

class ShowDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(intent.extras != null)
        {
            binding.tvName.text = "Nama: " + intent.getStringExtra("name")
            binding.tvEmail.text = "Email: " + intent.getStringExtra("email")
            binding.tvJurusan.text = "Jurusan: " + intent.getStringExtra("jurusan")
            binding.tvSemester.text = "Semester: " + intent.getStringExtra("semester")
        }
    }
}