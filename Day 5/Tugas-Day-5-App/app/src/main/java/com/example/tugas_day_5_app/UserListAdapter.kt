package com.example.tugas_day_5_app

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugas_day_5_app.databinding.ShowItemListBinding
import com.example.tugas_day_5_app.networking.UserGithubModel

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    private var listOfUser = ArrayList<UserGithubModel>()


    @SuppressLint("NotifyDataSetChanged")
    fun addedListOfUsers(list: List<UserGithubModel>) {
        this.listOfUser.clear()
        this.listOfUser.addAll(list)
        notifyDataSetChanged()
    }


    inner class UserListViewHolder(private val binding: ShowItemListBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun bind(position: Int) {
            val itemNow = listOfUser[position]
            binding.tvUsername.text = itemNow.userName

            Glide
                .with(itemView.context)
                .load(itemNow.avatarURL)
                .into(binding.ivProfile)

            binding.layoutShowItemList.setOnClickListener {
                Toast.makeText(itemView.context, itemNow.userName, Toast.LENGTH_SHORT).show()

                val intent = Intent(itemView.context, DetailUserActivity::class.java)
                intent.putExtra("username", itemNow.userName)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListViewHolder {
        return UserListViewHolder(
            ShowItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfUser.size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(position)
    }
}
