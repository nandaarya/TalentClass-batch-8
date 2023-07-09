package com.example.tugas_day_5_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugas_day_5_app.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setDetailData()

        setViewPager()
    }

    private fun setDetailData() {
        if(intent.extras != null)
        {
            binding.tvUsername.text = intent.getStringExtra("username")
            binding.tvName.text = intent.getStringExtra("name")
            binding.tvEmail.text = intent.getStringExtra("email")
            binding.tvCompany.text = intent.getStringExtra("company")

            Glide.with(binding.root.context)
                .load(intent.getStringExtra("photoProfile"))
                .apply(RequestOptions().centerCrop())
                .into(binding.ivProfile)
        }
    }

    private  fun setViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = viewPagerAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}