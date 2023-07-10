package com.example.tugas_day_5_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_day_5_app.adapter.UserListAdapter
import com.example.tugas_day_5_app.databinding.ActivityMainBinding
import com.example.tugas_day_5_app.api.ApiConfig
import com.example.tugas_day_5_app.api.GithubUserApiService
import com.example.tugas_day_5_app.model.UserGithubModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val client = ApiConfig.getApiService()

        settingRVUsers(client)
    }

    private fun settingRVUsers(client: GithubUserApiService) {
        val rvUserListAdapter = UserListAdapter()
        val getListUsersFromClient = client.getListUsers()

        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        binding.rvUserList.adapter = rvUserListAdapter

        showLoading(true)

        getListUsersFromClient.enqueue(object : Callback<List<UserGithubModel>> {
            override fun onResponse(
                call: Call<List<UserGithubModel>>,
                response: Response<List<UserGithubModel>>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (!responseBody.isNullOrEmpty()) {
                        rvUserListAdapter.addedListOfUsers(responseBody)
                    }
                } else {
                    Log.e("failedGetListUser", "onFailed: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<UserGithubModel>>, t: Throwable) {
                showLoading(false)
                Log.e("failedGetListUser", "onFailed: ${t.message}")
            }

        })
    }

    private fun showLoading(isShow: Boolean) {
        if (isShow) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}