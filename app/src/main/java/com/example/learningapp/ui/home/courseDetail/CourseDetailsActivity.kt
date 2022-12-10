package com.example.learningapp.ui.home.courseDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.databinding.ActivityCourseDetailBinding
import com.example.learningapp.ui.home.CourseItem
import com.example.learningapp.ui.home.CoursesListAdapter
import java.util.Objects

class CourseDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailBinding

    // in the list pass the model of Language
    private lateinit var courseTopicAdapter: CourseDetailTopicAdapter

    companion object{
        fun getCallingIntent(context: Context,courseItem: CourseItem):Intent{
            return Intent(context, CourseDetailsActivity::class.java)
                .putExtra("CourseDetailItem", courseItem)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCourseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseItem = intent.extras?.get("CourseDetailItem") as CourseItem
        Log.d("CourseDetailActivity",courseItem.toString())

        binding.txtCourseName.text = courseItem.courseName?:""
        binding.txtCourseLevel.text = courseItem.courseLevel?:""

        binding.courseProgress.text = courseItem.progressLevel?.let {
            it.toString()+"%"
        }
        binding.progressBar.progress = courseItem.progressLevel?:0

        val count = courseItem.milestones?:0
        setMilestone(count)
        binding.txtNoOfMilestone.text = "$count milestones"

        binding.imgLeftArrow.setOnClickListener {
            finish()
        }

        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)

        // pass it to  layoutManager
        binding.recyclerView.layoutManager = layoutManager

        // initialize the adapter,
        // and pass the required argument
        courseTopicAdapter = CourseDetailTopicAdapter(this,courseItem.courseDetailTopics!!)

        // attach adapter to the recycler view
        binding.recyclerView.adapter = courseTopicAdapter


    }

    fun setMilestone(level:Int){
        when(level){
            0 -> {
                binding.milestoneOne.visibility = View.GONE
                binding.milestoneTwo.visibility = View.GONE
                binding.milestoneThree.visibility = View.GONE
                binding.milestoneFour.visibility = View.GONE
                binding.milestoneFive.visibility = View.GONE
                binding.milestoneSix.visibility = View.GONE
            }
            1 -> {
                binding.milestoneOne.visibility = View.VISIBLE
                binding.milestoneTwo.visibility = View.GONE
                binding.milestoneThree.visibility = View.GONE
                binding.milestoneFour.visibility = View.GONE
                binding.milestoneFive.visibility = View.GONE
                binding.milestoneSix.visibility = View.GONE
            }
            2 -> {
                binding.milestoneOne.visibility = View.VISIBLE
                binding.milestoneTwo.visibility = View.VISIBLE
                binding.milestoneThree.visibility = View.GONE
                binding.milestoneFour.visibility = View.GONE
                binding.milestoneFive.visibility = View.GONE
                binding.milestoneSix.visibility = View.GONE
            }
            3 -> {
                binding.milestoneOne.visibility = View.VISIBLE
                binding.milestoneTwo.visibility = View.VISIBLE
                binding.milestoneThree.visibility = View.VISIBLE
                binding.milestoneFour.visibility = View.GONE
                binding.milestoneFive.visibility = View.GONE
                binding.milestoneSix.visibility = View.GONE
            }
            4 -> {
                binding.milestoneOne.visibility = View.VISIBLE
                binding.milestoneTwo.visibility = View.VISIBLE
                binding.milestoneThree.visibility = View.VISIBLE
                binding.milestoneFour.visibility = View.VISIBLE
                binding.milestoneFive.visibility = View.GONE
                binding.milestoneSix.visibility = View.GONE
            }
            5 -> {
                binding.milestoneOne.visibility = View.VISIBLE
                binding.milestoneTwo.visibility = View.VISIBLE
                binding.milestoneThree.visibility = View.VISIBLE
                binding.milestoneFour.visibility = View.VISIBLE
                binding.milestoneFive.visibility = View.VISIBLE
                binding.milestoneSix.visibility = View.GONE
            }
            6 -> {
                binding.milestoneOne.visibility = View.VISIBLE
                binding.milestoneTwo.visibility = View.VISIBLE
                binding.milestoneThree.visibility = View.VISIBLE
                binding.milestoneFour.visibility = View.VISIBLE
                binding.milestoneFive.visibility = View.VISIBLE
                binding.milestoneSix.visibility = View.VISIBLE
            }
        }
    }



}