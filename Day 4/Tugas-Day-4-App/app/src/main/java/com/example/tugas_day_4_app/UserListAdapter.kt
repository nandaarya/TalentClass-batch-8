package com.example.tugas_day_4_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugas_day_4_app.databinding.ShowItemListBinding

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    private var listOfName = ArrayList<String>()
    private var listOfEmail = ArrayList<String>()
    private var listOfJurusan = ArrayList<String>()
    private var listOfSemester = ArrayList<Int>()
    private var listOfImage = ArrayList<String>()

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
        this.listOfSemester.addAll(list)
        notifyDataSetChanged()
    }

    fun addListOfImage(list: List<String>) {
        this.listOfImage.clear()
        this.listOfImage.addAll(list)
        notifyDataSetChanged()
    }

    inner class UserListViewHolder(private val binding: ShowItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val nameNow = listOfName[position]
            val emailNow = listOfEmail[position]
            val jurusanNow = listOfJurusan[position]
            val semesterNow = listOfSemester[position]
            val imageNow = listOfImage[position]

            binding.tvName.text = nameNow
            binding.tvEmail.text = emailNow
            binding.tvJurusan.text = jurusanNow
            binding.tvSemester.text = "Semester " + semesterNow.toString()

            Glide.with(binding.root.context)
                .load(imageNow)
                .apply(RequestOptions().centerCrop())
                .into(binding.ivProfile)

            binding.layoutShowItemList.setOnClickListener{
                Toast.makeText(itemView.context, nameNow, Toast.LENGTH_SHORT).show()

                val intent = Intent(itemView.context, DetailUserActivity::class.java)
                intent.putExtra("name", nameNow)
                intent.putExtra("email", emailNow)
                intent.putExtra("jurusan", jurusanNow)
                intent.putExtra("semester", semesterNow.toString())
                intent.putExtra("image", imageNow)
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
        return listOfName.size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(position)
    }
}