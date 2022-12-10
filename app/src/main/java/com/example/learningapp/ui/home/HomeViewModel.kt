package com.example.learningapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapp.constant.AppConstants

class HomeViewModel : ViewModel() {

    private lateinit var courseList : List<CourseItem>

    private val _courseList = MutableLiveData<List<CourseItem>>().apply {
        loadCourses()
        value = courseList
    }


    // add items to the list manually in our case
    private fun loadCourses() {



        courseList = listOf(
            CourseItem("Spanish" , "Beginner",40,2,
                listOf(
                    CourseDetailTopics(AppConstants.CONST_VAL_BASICS,"Basics","4/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_OCCUPATIONS,"Occupations","1/5",20),
                    CourseDetailTopics(AppConstants.CONST_VAL_CONVERSATION,"Conversation","3/5",40),
                    CourseDetailTopics(AppConstants.CONST_VAL_PLACES,"Places","1/5",30),
                    CourseDetailTopics(AppConstants.CONST_VAL_FAMILY_MEMBERS,"Family Members","3/5",60),
                    CourseDetailTopics(AppConstants.CONST_VAL_FOODS,"FOODS","2/5",40)
                )),
            CourseItem("Italian" , "Advanced",60,3,
                listOf(
                    CourseDetailTopics(AppConstants.CONST_VAL_BASICS,"Basics","4/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_OCCUPATIONS,"Occupations","2/5",50),
                    CourseDetailTopics(AppConstants.CONST_VAL_CONVERSATION,"Conversation","4/5",20),
                    CourseDetailTopics(AppConstants.CONST_VAL_PLACES,"Places","3/5",35),
                    CourseDetailTopics(AppConstants.CONST_VAL_FAMILY_MEMBERS,"Family Members","2/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_FOODS,"FOODS","3/5",50)
                )
            ),
            CourseItem("German" , "Moderate",40,4,
                listOf(
                    CourseDetailTopics(AppConstants.CONST_VAL_BASICS,"Basics","4/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_OCCUPATIONS,"Occupations","2/5",50),
                    CourseDetailTopics(AppConstants.CONST_VAL_CONVERSATION,"Conversation","4/5",20),
                    CourseDetailTopics(AppConstants.CONST_VAL_PLACES,"Places","3/5",35),
                    CourseDetailTopics(AppConstants.CONST_VAL_FAMILY_MEMBERS,"Family Members","2/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_FOODS,"FOODS","3/5",50)
                )),
            CourseItem("English" , "Moderate",50,5,
                listOf(
                    CourseDetailTopics(AppConstants.CONST_VAL_BASICS,"Basics","4/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_OCCUPATIONS,"Occupations","2/5",50),
                    CourseDetailTopics(AppConstants.CONST_VAL_CONVERSATION,"Conversation","4/5",20),
                    CourseDetailTopics(AppConstants.CONST_VAL_PLACES,"Places","3/5",35),
                    CourseDetailTopics(AppConstants.CONST_VAL_FAMILY_MEMBERS,"Family Members","2/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_FOODS,"FOODS","3/5",50)
                )),
            CourseItem("Tamil" , "Advanced",90,2,
                listOf(
                    CourseDetailTopics(AppConstants.CONST_VAL_BASICS,"Basics","4/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_OCCUPATIONS,"Occupations","2/5",50),
                    CourseDetailTopics(AppConstants.CONST_VAL_CONVERSATION,"Conversation","4/5",20),
                    CourseDetailTopics(AppConstants.CONST_VAL_PLACES,"Places","3/5",35),
                    CourseDetailTopics(AppConstants.CONST_VAL_FAMILY_MEMBERS,"Family Members","2/5",80),
                    CourseDetailTopics(AppConstants.CONST_VAL_FOODS,"FOODS","3/5",50)
                ))
        )
    }
    val courseListLiveData: LiveData<List<CourseItem>> = _courseList
}

