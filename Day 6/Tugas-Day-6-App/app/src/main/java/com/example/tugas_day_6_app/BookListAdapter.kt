package com.example.tugas_day_6_app

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugas_day_6_app.databinding.ShowItemListBinding
import com.example.tugas_day_6_app.model.BookFirebaseRealtimeDBModel

class BookListAdapter : RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {

    private var listOfBook = ArrayList<BookFirebaseRealtimeDBModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addedListOfBooks(list: List<BookFirebaseRealtimeDBModel>) {
        this.listOfBook.clear()
        this.listOfBook.addAll(list)
        notifyDataSetChanged()
    }


    inner class BookListViewHolder(private val binding: ShowItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val itemNow = listOfBook[position]
            binding.tvBookTitle.text = itemNow.bookTitle
            binding.tvAuthorName.text = itemNow.authorName

            Glide
                .with(itemView.context)
                .load(itemNow.bookCoverURL)
                .fitCenter()
                .into(binding.ivBookCoverUrl)

            binding.layoutShowItemList.setOnClickListener {
                val intent = Intent(itemView.context, DetailBookActivity::class.java)
                intent.putExtra("bookCoverURL", itemNow.bookCoverURL)
                intent.putExtra("bookTitle", itemNow.bookTitle)
                intent.putExtra("authorName", itemNow.authorName)
                intent.putExtra("publicationYear", itemNow.publicationYear)
                intent.putExtra("category", itemNow.category)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookListAdapter.BookListViewHolder {
        return BookListViewHolder(
            ShowItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookListAdapter.BookListViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return listOfBook.size
    }
}