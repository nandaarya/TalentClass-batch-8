package com.example.tugas_day_3_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugas_day_3_app.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setDetailData()
    }

    private fun setDetailData() {
        if(intent.extras != null)
        {
            binding.tvName.text = intent.getStringExtra("name")
            binding.tvEmail.text = intent.getStringExtra("email")
            binding.tvJurusan.text = intent.getStringExtra("jurusan")
            binding.tvSemester.text = "Semester " + intent.getStringExtra("semester")

            Glide.with(binding.root.context)
                .load(intent.getStringExtra("image"))
                .apply(RequestOptions().centerCrop())
                .into(binding.ivProfile)
        }
    }
}