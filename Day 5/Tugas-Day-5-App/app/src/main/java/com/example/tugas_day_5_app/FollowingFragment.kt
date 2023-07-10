package com.example.tugas_day_5_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_day_5_app.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {

    private lateinit var binding: FragmentFollowingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFollowingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setUserList()
    }

//    private fun setUserList() {
//        val rvUserListAdapter = UserListAdapter()
//
//        binding.rvUserList.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvUserList.adapter = rvUserListAdapter
//
//        rvUserListAdapter.setUserList(userList)
//    }
}