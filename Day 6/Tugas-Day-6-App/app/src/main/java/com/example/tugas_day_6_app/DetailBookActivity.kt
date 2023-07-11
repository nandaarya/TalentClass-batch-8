package com.example.tugas_day_6_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.tugas_day_6_app.databinding.ActivityDetailBookBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBookBinding
    private lateinit var database: DatabaseReference
    private lateinit var bookTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        settingFirebaseRealtimeDB()
        setData()
        setButton()
    }

    private fun setData(): String {
        if (intent.extras != null) {
            bookTitle = intent.getStringExtra("bookTitle")!!
            val authorName = intent.getStringExtra("authorName")
            val publicationYear = intent.getStringExtra("publicationYear")
            val category = intent.getStringExtra("category")
            val bookCoverURL = intent.getStringExtra("bookCoverURL")

            binding.tvBookTitle.text = bookTitle
            binding.tvAuthorName.text = authorName
            binding.tvPublicationYear.text = publicationYear
            binding.tvCategory.text = category

            Glide
                .with(this)
                .load(bookCoverURL)
                .into(binding.ivBookCover)
        }
        return bookTitle
    }

    private fun setButton() {
        binding.btnDeleteBook.setOnClickListener {
            deleteDataFromFirebaseRealtimeDB()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun settingFirebaseRealtimeDB() {
        database = FirebaseDatabase.getInstance().getReference("Books")
    }


    private fun deleteDataFromFirebaseRealtimeDB() {
        val bookRef = database.child(bookTitle)

        bookRef.removeValue()
            .addOnSuccessListener {
                Toast.makeText(this@DetailBookActivity, "Data berhasil dihapus!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this@DetailBookActivity, "Gagal menghapus data!", Toast.LENGTH_SHORT).show()
            }
    }

}