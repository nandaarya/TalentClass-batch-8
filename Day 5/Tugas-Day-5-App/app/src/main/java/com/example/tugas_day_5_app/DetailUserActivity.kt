package com.example.tugas_day_5_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugas_day_5_app.databinding.ActivityDetailUserBinding
import com.example.tugas_day_5_app.networking.ApiConfig
import com.example.tugas_day_5_app.networking.DetailUserGithubModel
import com.example.tugas_day_5_app.networking.GithubUserApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val client = ApiConfig.getApiService()

        setDetailUser(client)

        setViewPager()
    }

    private fun setDetailUser(client: GithubUserApiService) {
        if(intent.extras != null)
        {
            val username = intent.getStringExtra("username")
            val getUserDetailFromClient = client.getDetailUser(username!!)

            showLoading(true)

            getUserDetailFromClient.enqueue(object : Callback<DetailUserGithubModel> {
                override fun onResponse(
                    call: Call<DetailUserGithubModel>,
                    response: Response<DetailUserGithubModel>
                ) {
                    showLoading(false)
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            binding.tvUsername.text = responseBody.userName ?: "Username Tidak Ada"
                            binding.tvName.text = responseBody.name ?: "Nama Tidak Ada"
                            binding.tvEmail.text = responseBody.email ?: "Email Tidak Ada"
                            binding.tvCompany.text = responseBody.company ?: "Company Tidak Ada"


                            Glide.with(binding.root.context)
                                .load(responseBody.avatarURL)
                                .apply(RequestOptions().centerCrop())
                                .into(binding.ivProfile)
                        }
                    } else {
                        Log.e("failedGetUserDetail", "onFailed: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<DetailUserGithubModel>, t: Throwable) {
                    showLoading(false)
                    Log.e("failedGetUserDetail", "onFailed: ${t.message}")
                }

            })

//            binding.tvUsername.text = intent.getStringExtra("username")
//            binding.tvName.text = intent.getStringExtra("name")
//            binding.tvEmail.text = intent.getStringExtra("email")
//            binding.tvCompany.text = intent.getStringExtra("company")
//
//            Glide.with(binding.root.context)
//                .load(intent.getStringExtra("photoProfile"))
//                .apply(RequestOptions().centerCrop())
//                .into(binding.ivProfile)
        }
    }

    private  fun setViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = viewPagerAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    private fun showLoading(isShow : Boolean) {
        if (isShow) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}