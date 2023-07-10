package com.example.tugas_day_5_app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_day_5_app.databinding.FragmentFollowerBinding
import com.example.tugas_day_5_app.networking.ApiConfig
import com.example.tugas_day_5_app.networking.GithubUserApiService
import com.example.tugas_day_5_app.networking.UserGithubModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerFragment : Fragment() {

    private lateinit var binding: FragmentFollowerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFollowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val client = ApiConfig.getApiService()
        setUserFollowerList(client)
    }

    private fun setUserFollowerList(client: GithubUserApiService) {
        val intent = activity?.intent
        val rvUserListAdapter = UserListAdapter()

        binding.rvUserList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUserList.adapter = rvUserListAdapter

        showLoading(true)

        if(intent?.extras != null) {
            val username = intent.getStringExtra("username")
            val getUserFollowerListFromClient = client.getUserFollowersList(username!!)

            getUserFollowerListFromClient.enqueue(object : Callback<List<UserGithubModel>> {
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
    }

    private fun showLoading(isShow : Boolean) {
        if (isShow) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}