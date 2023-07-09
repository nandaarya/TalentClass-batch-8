package com.example.tugas_day_5_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugas_day_5_app.databinding.ShowItemListBinding

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    private var userList = ArrayList<UserData>()

    fun setUserList(list: List<UserData>) {
        userList.clear()
        userList.addAll(list)
        notifyDataSetChanged()
    }

    inner class UserListViewHolder(private val binding: ShowItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserData) {
            binding.tvUsername.text = user.username

            Glide.with(binding.root.context)
                .load(user.photoProfile)
                .apply(RequestOptions().centerCrop())
                .into(binding.ivProfile)

            binding.layoutShowItemList.setOnClickListener {
                Toast.makeText(itemView.context, user.name, Toast.LENGTH_SHORT).show()

                val intent = Intent(itemView.context, DetailUserActivity::class.java)
                intent.putExtra("photoProfile", user.photoProfile)
                intent.putExtra("username", user.username)
                intent.putExtra("name", user.name)
                intent.putExtra("email", user.email)
                intent.putExtra("company", user.company)
//                intent.putExtra("follower", user.follower.toString())
//                intent.putExtra("following", user.following.toString())
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            ShowItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }
}
