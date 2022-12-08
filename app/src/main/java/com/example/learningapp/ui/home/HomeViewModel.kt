package com.example.learningapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private lateinit var courseList : List<CourseItem>

    private val _courseList = MutableLiveData<List<CourseItem>>().apply {
        loadCourses()
        value = courseList
    }


    // add items to the list manually in our case
    private fun loadCourses() {
        courseList = listOf(
            CourseItem("Spanish" , "Beginner",40),
            CourseItem("Italian" , "Advanced",60),
            CourseItem("German" , "Moderate",40),
            CourseItem("English" , "Moderate",50),
            CourseItem("Tamil" , "Advanced",90)
        )
    }
    val courseListLiveData: LiveData<List<CourseItem>> = _courseList
}

