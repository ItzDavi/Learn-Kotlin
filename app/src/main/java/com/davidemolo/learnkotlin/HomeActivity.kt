package com.davidemolo.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.databinding.ActivityHomeBinding
import com.davidemolo.learnkotlin.topics.TopicAdapter
import com.davidemolo.learnkotlin.topics.TopicViewModel
import com.davidemolo.learnkotlin.topics.lessons.LessonAdapter
import com.davidemolo.learnkotlin.topics.lessons.LessonViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val poppinsRegular = ResourcesCompat.getFont(this, R.font.poppinsregular)

        binding.welcomeTextview.typeface = poppinsRegular

        val slideInDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_down)
        val slideInUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)
        val slideInRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)

        val slideOutUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_up)
        val slideOutDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_down)

        val topicsRecyclerView = binding.topicsRecyclerview
        topicsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val lessonsRecyclerView = binding.lessonsRecyclerview
        lessonsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        loadTopics(topicsRecyclerView)
        loadLessons(lessonsRecyclerView, "Kotlin")

        lifecycleScope.launch {
            delay(600)
            binding.homeCustomAppbar.visibility = View.VISIBLE
            binding.homeCustomAppbar.startAnimation(slideInDownAnimation)

            delay(300)
            binding.topicsTextview.visibility = View.VISIBLE
            binding.topicsTextview.startAnimation(slideInRightAnimation)

            delay(600)
            binding.topicsScrollview.visibility = View.VISIBLE
            binding.topicsScrollview.startAnimation(slideInRightAnimation)

            delay(600)
            binding.lessonsTextview.visibility = View.VISIBLE
            binding.lessonsTextview.startAnimation(slideInUpAnimation)

            delay(300)
            binding.lessonsBackCardview.visibility = View.VISIBLE
            binding.lessonsBackCardview.startAnimation(slideInRightAnimation)
        }
    }

    private fun loadTopics(topicsRecyclerView: RecyclerView) {
        val topicsData = ArrayList<TopicViewModel>()

        topicsData.add(TopicViewModel("Kotlin", 1, 2, 1, "English"))
        topicsData.add(TopicViewModel("Variables", 2, 2, 1, "English"))
        topicsData.add(TopicViewModel("Activities", 3, 3, 2, "English"))
        topicsData.add(TopicViewModel("Conditions", 1, 2, 2, "English"))
        topicsData.add(TopicViewModel("Loops", 1, 2, 2, "English"))
        topicsData.add(TopicViewModel("Layouts", 2, 3, 3, "English"))
        topicsData.add(TopicViewModel("Events", 2, 3, 2, "English"))
        topicsData.add(TopicViewModel("WebView", 1, 1, 1, "English"))
        topicsData.add(TopicViewModel("RecyclerView", 4, 5, 5, "English"))
        topicsData.add(TopicViewModel("Fragments", 2, 3, 3, "English"))
        topicsData.add(TopicViewModel("ViewBinding", 1, 1, 1, "English"))
        topicsData.add(TopicViewModel("Animations", 2, 2, 2, "English"))

        val adapter = TopicAdapter(topicsData, this)
        topicsRecyclerView.adapter = adapter
    }

    private fun loadLessons(lessonsRecyclerView: RecyclerView, topic: String) {
        val lessonsData = ArrayList<LessonViewModel>()

        when(topic) {
            "Kotlin" -> {
                lessonsData.add(LessonViewModel( "01", "What is Kotlin ?"))
                lessonsData.add(LessonViewModel( "02", "Project creation"))
            }

            "Variables" -> {
                lessonsData.add(LessonViewModel( "01", "Data types, val, var"))
                lessonsData.add(LessonViewModel( "02", "Lateinit, private"))
            }

            "Activity" -> {
                lessonsData.add(LessonViewModel( "01", "What is and acvitity ?"))
                lessonsData.add(LessonViewModel( "02", "Lifecycles"))
                lessonsData.add(LessonViewModel( "03", "Activities structure"))
            }

            "Conditions" -> {
                lessonsData.add(LessonViewModel( "01", "If else, when, ? x : y"))
            }
        }

        val adapter = LessonAdapter(lessonsData, this)
        lessonsRecyclerView.adapter = adapter
    }
}