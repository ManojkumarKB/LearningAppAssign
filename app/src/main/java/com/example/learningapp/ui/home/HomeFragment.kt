package com.example.learningapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(),CoursesListAdapter.ActionListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // in the list pass the model of Language
    private lateinit var courseAdapter: CoursesListAdapter
    private lateinit var courseList : List<CourseItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root



        homeViewModel.courseListLiveData.observe(viewLifecycleOwner) {
            courseList = it

            // create  layoutManager
            val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

            // pass it to  layoutManager
            binding.recyclerVwCourses.layoutManager = layoutManager

            // initialize the adapter,
            // and pass the required argument
            courseAdapter = CoursesListAdapter(requireContext(),courseList,this)

            // attach adapter to the recycler view
            binding.recyclerVwCourses.adapter = courseAdapter
        }


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickCourse(courseItem: CourseItem, position: Int) {
        Toast.makeText(requireContext(),courseItem.courseLevel+" selected", Toast.LENGTH_LONG).show()
    }


}