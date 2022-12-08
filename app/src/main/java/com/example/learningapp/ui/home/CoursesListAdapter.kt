package com.example.learningapp.ui.home

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.R
import com.example.learningapp.databinding.ItemCourseBinding

class CoursesListAdapter(
    var ctx:Context,
    var courseList: List<CourseItem>,
    var actionListener: ActionListener
) : RecyclerView.Adapter<CoursesListAdapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie ItemCourseBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: ItemCourseBinding) : RecyclerView.ViewHolder(binding.root)

    private var colorList = listOf(R.color.orange,R.color.green,R.color.darkblue)
    // inside the onCreateViewHolder inflate the view of CourseItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    // bind the items with each item
    // of the list languageList
    // which than will be
    // shown in recycler view
    // to keep it simple we are
    // not setting any image data to view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            courseList.apply {
                binding.txtCourseName.text = this[position].courseName
                binding.txtCourseLevel.text = this[position].courseLevel
                binding.progressBar.progress = this[position].progressLevel?:0
                binding.courseProgress.text = this[position].progressLevel.toString()+"%"
                binding.courseItemLayout.backgroundTintList =  ctx.resources.getColorStateList(colorList[position%3],null)
                binding.courseItemLayout.setOnClickListener {
                    actionListener.onClickCourse(this[position],position)
                }
            }
        }
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return courseList.size
    }

    interface ActionListener{
        fun onClickCourse(courseItem: CourseItem,position: Int)
    }
}
