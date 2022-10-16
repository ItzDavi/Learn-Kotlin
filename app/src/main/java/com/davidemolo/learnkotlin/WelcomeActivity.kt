package com.davidemolo.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import com.davidemolo.learnkotlin.databinding.ActivityWelcomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val poppinsRegular = ResourcesCompat.getFont(this, R.font.poppinsregular)

        val slideInDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_down)
        val slideInUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)

        val slideOutUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_up)
        val slideOutDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_down)

        lifecycleScope.launch {
            delay(600)
            binding.welcomeTextview.typeface = poppinsRegular
            binding.welcomeTextview.visibility = View.VISIBLE
            binding.welcomeTextview.startAnimation(slideInDownAnimation)
            delay(600)
            binding.startButton.typeface = poppinsRegular
            binding.startButton.visibility = View.VISIBLE
            binding.startButton.startAnimation(slideInUpAnimation)
        }

        binding.startButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)

            binding.welcomeTextview.startAnimation(slideOutUpAnimation)
            binding.startButton.startAnimation(slideOutDownAnimation)

            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }
    }
}