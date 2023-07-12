package com.example.tugas_day_6_app

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas_day_6_app.databinding.ActivityEditDetailBookBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditDetailBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditDetailBookBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditDetailBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        settingFirebaseRealtimeDB()
        setData()
    }

    private fun setData() {
        if (intent.extras != null) {
            val bookTitle = intent.getStringExtra("bookTitle")!!
            val authorName = intent.getStringExtra("authorName")!!
            val publicationYear = intent.getStringExtra("publicationYear")!!
            val category = intent.getStringExtra("category")!!
            val bookCoverURL = intent.getStringExtra("bookCoverURL")!!

            binding.etBookTitle.text = Editable.Factory.getInstance().newEditable(bookTitle)
            binding.etAuthorName.text = Editable.Factory.getInstance().newEditable(authorName)
            binding.etPublicationYear.text = Editable.Factory.getInstance().newEditable(publicationYear)
            binding.etCategory.text = Editable.Factory.getInstance().newEditable(category)
            binding.etBookCoverUrl.text = Editable.Factory.getInstance().newEditable(bookCoverURL)

        }
    }

    private fun settingFirebaseRealtimeDB() {
        database = FirebaseDatabase.getInstance().getReference("Books")
    }
}