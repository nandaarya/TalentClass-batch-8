package com.example.tugas_day_6_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_day_6_app.databinding.ActivityMainBinding
import com.example.tugas_day_6_app.model.BookFirebaseRealtimeDBModel
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setFAB()

        settingFirebaseRealtimeDB()

        readDataFromFirebaseRealtimeDB()
    }

    private fun setFAB() {
        binding.fabAddBook.setOnClickListener{
            val intent = Intent(this, AddBookActivity::class.java)
            startActivity(intent)
        }
    }

    private fun settingFirebaseRealtimeDB() {
        database = FirebaseDatabase.getInstance().getReference("Books")
    }

    private fun readDataFromFirebaseRealtimeDB() {
        showLoading(false)

        val bookList = mutableListOf<BookFirebaseRealtimeDBModel>()

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                bookList.clear()
                for (snapshot in dataSnapshot.children) {
                    val bookTitle = snapshot.key.toString()
                    val authorName = snapshot.child("authorName").value.toString()
                    val publicationYear = snapshot.child("publicationYear").value.toString()
                    val category = snapshot.child("category").value.toString()
                    val bookCoverURL = snapshot.child("bookCoverURL").value.toString()

                    val book = BookFirebaseRealtimeDBModel(bookTitle, authorName, publicationYear, category, bookCoverURL)

                    bookList.add(book)
                }
                settingRVBooks(bookList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Penanganan kesalahan saat membaca data
                Toast.makeText(this@MainActivity, "Gagal membaca data!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun settingRVBooks(book : List<BookFirebaseRealtimeDBModel>) {
        val rvBookListAdapter = BookListAdapter()

        binding.rvBookList.layoutManager = LinearLayoutManager(this)
        binding.rvBookList.adapter = rvBookListAdapter

        rvBookListAdapter.addedListOfBooks(book)
    }

    private fun showLoading(isShow: Boolean) {
        if (isShow) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}