package com.example.tugas_day_3_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_day_3_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUserList()
    }

    private fun setUserList() {
        val listNames = listOf(
            "Budi Santoso",
            "Rina Kartika",
            "Ahmad Hidayat",
            "Siti Aisyah",
            "Joko Prasetyo",
            "Dewi Rahayu",
            "Hendra Wijaya",
            "Linda Sari",
            "Eko Nugroho",
            "Dian Purnama"
        )

        val listEmails = listOf(
            "BudiSantoso@gmail.com",
            "RinaKartika@gmail.com",
            "AhmadHidayat@gmail.com",
            "SitiAisyah@gmail.com",
            "JokoPrasetyo@gmail.com",
            "DewiRahayu@gmail.com",
            "HendraWijaya@gmail.com",
            "LindaSari@gmail.com",
            "EkoNugroho@gmail.com",
            "DianPurnama@gmail.com"
        )

        val listJurusan = listOf(
            "Teknik Informatika",
            "Akuntansi",
            "Psikologi",
            "Ilmu Komunikasi",
            "Manajemen",
            "Hukum",
            "Ekonomi",
            "Kedokteran",
            "Arsitektur",
            "Desain Grafis"
        )

        val listSemester = listOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        )

        val listImages = listOf(
            "https://st.depositphotos.com/2931363/5142/i/450/depositphotos_51425493-stock-photo-student-holding-textbooks.jpg",
            "https://st4.depositphotos.com/2760050/38295/i/450/depositphotos_382951958-stock-photo-library-makes-you-visionary-library.jpg",
            "https://st2.depositphotos.com/4431055/11853/i/450/depositphotos_118536368-stock-photo-student-man-with-laptop.jpg",
            "https://st2.depositphotos.com/1594308/12210/i/450/depositphotos_122104332-stock-photo-female-college-student.jpg",
            "https://st.depositphotos.com/1715570/5146/i/450/depositphotos_51462919-stock-photo-happy-young-man-traveling-with.jpg",
            "https://st2.depositphotos.com/3889193/6374/i/450/depositphotos_63745245-stock-photo-cute-student-girl-taking-notes.jpg",
            "https://st4.depositphotos.com/1158045/19931/i/450/depositphotos_199311608-stock-photo-handsome-young-man-reading-book.jpg",
            "https://st2.depositphotos.com/4431055/11856/i/450/depositphotos_118562150-stock-photo-young-student-girl.jpg",
            "https://st4.depositphotos.com/12982378/25187/i/450/depositphotos_251879625-stock-photo-smiling-student-red-shirt-sitting.jpg",
            "https://st.depositphotos.com/1594308/2419/i/450/depositphotos_24196475-stock-photo-student-with-copybook.jpg"
        )

        val rvUserListAdapter = UserListAdapter()

        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        binding.rvUserList.adapter = rvUserListAdapter

        rvUserListAdapter.addListOfName(listNames)
        rvUserListAdapter.addListOfEmail(listEmails)
        rvUserListAdapter.addListOfJurusan(listJurusan)
        rvUserListAdapter.addListOfSemester(listSemester)
        rvUserListAdapter.addListOfImage(listImages)
    }
}