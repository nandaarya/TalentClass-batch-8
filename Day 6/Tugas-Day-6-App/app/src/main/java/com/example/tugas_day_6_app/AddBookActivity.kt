package com.example.tugas_day_6_app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas_day_6_app.databinding.ActivityAddBookBinding
import com.example.tugas_day_6_app.model.BookFirebaseRealtimeDBModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBookBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        settingFirebaseRealtimeDB()

        settingSaveButton()
    }

    private fun settingFirebaseRealtimeDB() {
        database = FirebaseDatabase.getInstance().getReference("Books")
    }

    private fun settingSaveButton() {
        binding.apply {
            btnAddBook.setOnClickListener {
                savedata()
            }
        }
    }

    private fun savedata() {
        binding.apply {
            val bookTitle = etBookTitle.text.toString()
            val authorName = etAuthorName.text.toString()
            val publicationYear = etPublicationYear.text.toString()
            val category = etCategory.text.toString()
            val bookCoverURL = etBookCoverUrl.text.toString()

            val book = BookFirebaseRealtimeDBModel(
                bookTitle,
                authorName,
                publicationYear,
                category,
                bookCoverURL
            )

            database.child(bookTitle).setValue(book).addOnSuccessListener {
                etBookTitle.text.clear()
                etAuthorName.text.clear()
                etPublicationYear.text.clear()
                etCategory.text.clear()
                etBookCoverUrl.text.clear()

                Toast.makeText(this@AddBookActivity, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
            }
                .addOnCanceledListener {
                    Toast.makeText(this@AddBookActivity, "Batal disimpan!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this@AddBookActivity, "Data Gagal disimpan!", Toast.LENGTH_SHORT).show()
                }

        }
    }
}