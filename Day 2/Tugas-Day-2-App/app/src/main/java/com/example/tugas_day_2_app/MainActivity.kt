package com.example.tugas_day_2_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas_day_2_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSendData.setOnClickListener{
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val jurusan = binding.etJurusan.text.toString()
            val semester = binding.etSemester.text.toString()

            if (name.isEmpty()) {
                binding.etName.error = "Nama tidak boleh kosong"
            }

            if (email.isEmpty()) {
                binding.etEmail.error = "Email tidak boleh kosong"
            }

            if (jurusan.isEmpty()) {
                binding.etJurusan.error = "Jurusan tidak boleh kosong"
            }

            if (semester.isEmpty()) {
                binding.etSemester.error = "Semester tidak boleh kosong"
            }

            if (!email.matches(Regex("[a-zA-Z\\d._-]+@gmail.com"))) {
                binding.etEmail.error = "Gunakan email @gmail.com"
            }

            if (name.isNotEmpty() && email.isNotEmpty() && jurusan.isNotEmpty() && semester.isNotEmpty() && email.matches(Regex("[a-zA-Z\\d._-]+@gmail.com"))) {
                val intent = Intent(this, ShowDataActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("jurusan", jurusan)
                intent.putExtra("semester", semester)
                startActivity(intent)
            }
        }
    }
}