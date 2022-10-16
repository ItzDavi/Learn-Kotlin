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

        lifecycleScope.launch {
            delay(600)
            binding.homeCustomAppbar.visibility = View.VISIBLE
            binding.homeCustomAppbar.startAnimation(slideInDownAnimation)

            loadTopics(topicsRecyclerView)

            delay(300)
            binding.topicsTextview.visibility = View.VISIBLE
            binding.topicsTextview.startAnimation(slideInRightAnimation)

            delay(600)
            binding.topicsScrollview.visibility = View.VISIBLE
            binding.topicsScrollview.startAnimation(slideInRightAnimation)
        }
    }

    private fun loadTopics(topicsRecyclerView: RecyclerView) {
        val topicsData = ArrayList<TopicViewModel>()

        topicsData.add(TopicViewModel("Kotlin", 1, 2, 1, "English"))
        topicsData.add(TopicViewModel("Variables", 2, 1, 1, "English"))
        topicsData.add(TopicViewModel("Activities", 3, 5, 2, "English"))

        val adapter = TopicAdapter(topicsData, this)
        topicsRecyclerView.adapter = adapter
    }
}