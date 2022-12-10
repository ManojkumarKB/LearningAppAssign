package com.example.learningapp.ui.home.courseDetail

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.R
import com.example.learningapp.constant.AppConstants.CONST_VAL_BASICS
import com.example.learningapp.constant.AppConstants.CONST_VAL_CONVERSATION
import com.example.learningapp.constant.AppConstants.CONST_VAL_FAMILY_MEMBERS
import com.example.learningapp.constant.AppConstants.CONST_VAL_FOODS
import com.example.learningapp.constant.AppConstants.CONST_VAL_OCCUPATIONS
import com.example.learningapp.constant.AppConstants.CONST_VAL_PLACES
import com.example.learningapp.databinding.ItemCourseBinding
import com.example.learningapp.databinding.ItemCourseDetailsBinding
import com.example.learningapp.ui.home.CourseDetailTopics
import com.example.learningapp.ui.home.CourseItem
import com.example.learningapp.ui.home.CoursesListAdapter

class CourseDetailTopicAdapter(
    var ctx: Context,
    var courseTopicList: List<CourseDetailTopics>
) : RecyclerView.Adapter<CourseDetailTopicAdapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie ItemCourseBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: ItemCourseDetailsBinding) : RecyclerView.ViewHolder(binding.root)

    private var colorList = listOf(R.color.yellow, R.color.red, R.color.shadedBlue, R.color.green, R.color.purple, R.color.darkblue)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseDetailTopicAdapter.ViewHolder {

        val binding = ItemCourseDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return courseTopicList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            courseTopicList.apply {
                binding.txtName.text = this[position].topicName?:""
                binding.txtLevel.text = this[position].topicLevel?:""
                binding.progressBar.progress = this[position].topicProgressLevel?:0

                when(this[position].courseDetailsTopicsConst){
                    CONST_VAL_BASICS ->{
                        binding.imgIcon.setImageDrawable(ctx.getDrawable(R.drawable.ic_baseline_basic_24))
                       // binding.progressBar.progressDrawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.yellow, BlendModeCompat.SRC_ATOP)
                    }
                    CONST_VAL_OCCUPATIONS -> {
                        binding.imgIcon.setImageDrawable(ctx.getDrawable(R.drawable.ic_baseline_work_24))
                       // binding.progressBar.progressDrawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.red, BlendModeCompat.SRC_ATOP)
                    }
                    CONST_VAL_CONVERSATION -> {
                        binding.imgIcon.setImageDrawable(ctx.getDrawable(R.drawable.ic_baseline_message_48))
                        //binding.progressBar.progressDrawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.shadedBlue, BlendModeCompat.SRC_ATOP)
                    }
                    CONST_VAL_PLACES -> {
                        binding.imgIcon.setImageDrawable(ctx.getDrawable(R.drawable.ic_baseline_location_on_24))
                       // binding.progressBar.progressDrawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.green, BlendModeCompat.SRC_ATOP)
                    }
                    CONST_VAL_FAMILY_MEMBERS -> {
                        binding.imgIcon.setImageDrawable(ctx.getDrawable(R.drawable.ic_baseline_family_restroom_24))
                       // binding.progressBar.progressDrawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.purple, BlendModeCompat.SRC_ATOP)
                    }
                    CONST_VAL_FOODS -> {
                        binding.imgIcon.setImageDrawable(ctx.getDrawable(R.drawable.ic_baseline_fastfood_24))
                       // binding.progressBar.progressDrawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.darkblue, BlendModeCompat.SRC_ATOP)
                    }
                    else -> {
                        binding.imgIcon.setImageDrawable(ctx.getDrawable(R.drawable.ic_baseline_basic_24))
                      //  binding.progressBar.progressDrawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.yellow, BlendModeCompat.SRC_ATOP)
                    }
                }

            }
        }
    }


}