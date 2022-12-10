package com.example.learningapp.ui.home

/*import com.example.learningapp.ui.home.courseDetail.CourseDetailTopics


data class CourseItem(
    var courseName:String? = null,
    var courseLevel:String? = null,
    var progressLevel:Int? = 0
)
*/

data class CourseItem(
    var courseName:String? = null,
    var courseLevel:String? = null,
    var progressLevel:Int? = 0,
    var milestones:Int? = 0,
    var courseDetailTopics:List<CourseDetailTopics>? = null
):java.io.Serializable

data class CourseDetailTopics(
    var courseDetailsTopicsConst:Int? = 0,
    var topicName:String? = null,
    var topicLevel:String? = null,
    var topicProgressLevel:Int? = 0
): java.io.Serializable


