package com.example.tugas_day_3_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_day_3_app.databinding.ShowItemListBinding

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    private var listOfName = ArrayList<String>()
    private var listOfEmail = ArrayList<String>()
    private var listOfJurusan = ArrayList<String>()
    private var listOfSemester = ArrayList<String>()

    fun addListOfName(list: List<String>) {
        this.listOfName.clear()
        this.listOfName.addAll(list)
        notifyDataSetChanged()
    }

    fun addListOfEmail(list: List<String>) {
        this.listOfEmail.clear()
        this.listOfEmail.addAll(list)
        notifyDataSetChanged()
    }

    fun addListOfJurusan(list: List<String>) {
        this.listOfJurusan.clear()
        this.listOfJurusan.addAll(list)
        notifyDataSetChanged()
    }

    fun addListOfSemester(list: List<Int>) {
        this.listOfSemester.clear()
        this.listOfSemester.addAll(list.map { it.toString() })
        notifyDataSetChanged()
    }

    inner class UserListViewHolder(private val binding: ShowItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val nameNow = listOfName[position]
            val emailNow = listOfEmail[position]
            val jurusanNow = listOfJurusan[position]
            val semesterNow = listOfSemester[position]

            binding.tvName.text = nameNow
            binding.tvEmail.text = emailNow
            binding.tvJurusan.text = jurusanNow
            binding.tvSemester.text = semesterNow
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
        return listOfName.size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(position)
    }
}