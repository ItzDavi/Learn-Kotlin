package com.davidemolo.learnkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        val poppinsBold = ResourcesCompat.getFont(this, R.font.poppinsbold)

        binding.welcomeTextview.typeface = poppinsBold

        val topicsRecyclerView = binding.topicsRecyclerview
        topicsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        loadTopics(topicsRecyclerView)

        lifecycleScope.launch {
            delay(600)
            MyAnimations.myAnimate(binding.homeCustomAppbar, MyAnimations.slideInDown, baseContext)

            delay(400)
            MyAnimations.myAnimate(binding.lessonsEmptyBackground, MyAnimations.slideInUp, baseContext)

            delay(300)
            MyAnimations.myAnimate(binding.topicsTextview, MyAnimations.slideInRight, baseContext)

            delay(600)
            MyAnimations.myAnimate(binding.topicsScrollview, MyAnimations.slideInRight, baseContext)
        }

        val infoButton = binding.homeInfoImageview
        infoButton.setOnClickListener {
            startActivity(Intent(this, InfoActivity::class.java))
            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down)
        }
    }

    private fun loadTopics(topicsRecyclerView: RecyclerView) {
        val topicsData = ArrayList<TopicViewModel>()

        topicsData.add(TopicViewModel("Kotlin", 1, 2, 1, "English"))
        topicsData.add(TopicViewModel("Variables", 2, 3, 1, "English"))
        topicsData.add(TopicViewModel("Activities", 3, 3, 2, "English"))
        topicsData.add(TopicViewModel("Conditions", 1, 3, 2, "English"))
        topicsData.add(TopicViewModel("Loops", 1, 2, 2, "English"))
        topicsData.add(TopicViewModel("Layouts", 2, 3, 3, "English"))
        topicsData.add(TopicViewModel("Events", 2, 2, 2, "English"))
        topicsData.add(TopicViewModel("WebView", 1, 3, 1, "English"))
        topicsData.add(TopicViewModel("Fragments", 2, 3, 4, "English"))
        topicsData.add(TopicViewModel("ViewBinding", 1, 2, 3, "English"))
        topicsData.add(TopicViewModel("Animations", 2, 4, 3, "English"))

        topicsRecyclerView.adapter = TopicAdapter(topicsData, this)
    }
}