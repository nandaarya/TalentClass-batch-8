package com.example.tugas_day_4_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_day_4_app.databinding.FragmentUserBBinding

class UserBFragment : Fragment() {

    private lateinit var binding: FragmentUserBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUserList()
    }

    private fun setUserList() {
        val listNames = listOf(
            "John Doe",
            "Jane Smith",
            "Michael Johnson",
            "Emily Brown",
            "David Davis",
            "Sarah Wilson",
            "Robert Anderson",
            "Jessica Thomas",
            "Daniel White",
            "Jennifer Lee"
        )

        val listEmails = listOf(
            "john.doe@gmail.com",
            "jane.smith@gmail.com",
            "michael.johnson@gmail.com",
            "emily.brown@gmail.com",
            "david.davis@gmail.com",
            "sarah.wilson@gmail.com",
            "robert.anderson@gmail.com",
            "jessica.thomas@gmail.com",
            "daniel.white@gmail.com",
            "jennifer.lee@gmail.com"
        )

        val listJurusan = listOf(
            "Teknik Sipil",
            "Fisika",
            "Biologi",
            "Seni Rupa",
            "Ilmu Politik",
            "Teknik Elektro",
            "Sastra Inggris",
            "Psikologi",
            "Ekonomi Islam",
            "Desain Interior"
        )


        val listSemester = listOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        )

        val listImages = listOf(
            "https://st4.depositphotos.com/12982378/25187/i/450/depositphotos_251879625-stock-photo-smiling-student-red-shirt-sitting.jpg",
            "https://st.depositphotos.com/1594308/2419/i/450/depositphotos_24196475-stock-photo-student-with-copybook.jpg",
            "https://st4.depositphotos.com/1158045/19931/i/450/depositphotos_199311608-stock-photo-handsome-young-man-reading-book.jpg",
            "https://st2.depositphotos.com/4431055/11856/i/450/depositphotos_118562150-stock-photo-young-student-girl.jpg",
            "https://st.depositphotos.com/1715570/5146/i/450/depositphotos_51462919-stock-photo-happy-young-man-traveling-with.jpg",
            "https://st2.depositphotos.com/3889193/6374/i/450/depositphotos_63745245-stock-photo-cute-student-girl-taking-notes.jpg",
            "https://st2.depositphotos.com/4431055/11853/i/450/depositphotos_118536368-stock-photo-student-man-with-laptop.jpg",
            "https://st2.depositphotos.com/1594308/12210/i/450/depositphotos_122104332-stock-photo-female-college-student.jpg",
            "https://st.depositphotos.com/2931363/5142/i/450/depositphotos_51425493-stock-photo-student-holding-textbooks.jpg",
            "https://st.depositphotos.com/1594308/2419/i/450/depositphotos_24196475-stock-photo-student-with-copybook.jpg"
        )

        val rvUserListAdapter = UserListAdapter()

        binding.rvUserList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUserList.adapter = rvUserListAdapter

        rvUserListAdapter.addListOfName(listNames)
        rvUserListAdapter.addListOfEmail(listEmails)
        rvUserListAdapter.addListOfJurusan(listJurusan)
        rvUserListAdapter.addListOfSemester(listSemester)
        rvUserListAdapter.addListOfImage(listImages)
    }
}