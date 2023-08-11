package com.example.tugas_day_6_app

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas_day_6_app.databinding.ActivityEditDetailBookBinding
import com.example.tugas_day_6_app.model.BookFirebaseRealtimeDBModel
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

        supportActionBar?.title = "Ubah Data Buku"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setData()
        settingFirebaseRealtimeDB()
        settingEditButton()
    }

    override fun onSupportNavigateUp(): Boolean {
        // Tindakan ketika tombol kembali ditekan
        @Suppress("DEPRECATION")
        onBackPressed()
        return true
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
            binding.etPublicationYear.text =
                Editable.Factory.getInstance().newEditable(publicationYear)
            binding.etCategory.text = Editable.Factory.getInstance().newEditable(category)
            binding.etBookCoverUrl.text = Editable.Factory.getInstance().newEditable(bookCoverURL)
        }
    }

    private fun settingFirebaseRealtimeDB() {
        database = FirebaseDatabase.getInstance().getReference("Books")
    }

    private fun settingEditButton() {
        binding.apply {
            btnEditBook.setOnClickListener {
                editData()
            }
        }
    }

    private fun editData() {
        val previousBookTitle = intent.getStringExtra("bookTitle")!!
        val bookTitle = binding.etBookTitle.text.toString()
        val authorName = binding.etAuthorName.text.toString()
        val publicationYear = binding.etPublicationYear.text.toString()
        val category = binding.etCategory.text.toString()
        val bookCoverURL = binding.etBookCoverUrl.text.toString()

        if (bookTitle.isEmpty()) {
            binding.etBookTitle.error = "Judul Buku tidak boleh kosong"
        }

        if (authorName.isEmpty()) {
            binding.etAuthorName.error = "Nama Penulis tidak boleh kosong"
        }

        if (publicationYear.isEmpty()) {
            binding.etPublicationYear.error = "Tahun terbit tidak boleh kosong"
        }

        if (category.isEmpty()) {
            binding.etCategory.error = "Kategori tidak boleh kosong"
        }

        if (bookCoverURL.isEmpty()) {
            binding.etBookCoverUrl.error = "URL Cover Buku tidak boleh kosong"
        }

        if (bookTitle.isNotEmpty() && authorName.isNotEmpty() && publicationYear.isNotEmpty() && category.isNotEmpty() && bookCoverURL.isNotEmpty()) {
            val book = BookFirebaseRealtimeDBModel(
                bookTitle,
                authorName,
                publicationYear,
                category,
                bookCoverURL
            )

            database.child(previousBookTitle).removeValue()

            database.child(bookTitle).setValue(book).addOnSuccessListener {
                Toast.makeText(
                    this@EditDetailBookActivity,
                    "Data berhasil diubah!",
                    Toast.LENGTH_SHORT
                )
                    .show()

                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
                .addOnCanceledListener {
                    Toast.makeText(this@EditDetailBookActivity, "Batal diubah!", Toast.LENGTH_SHORT)
                        .show()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this@EditDetailBookActivity,
                        "Data Gagal diubah!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
        }

    }
}