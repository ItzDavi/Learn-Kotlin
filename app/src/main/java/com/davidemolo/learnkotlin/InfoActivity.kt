package com.davidemolo.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.lifecycle.lifecycleScope
import com.davidemolo.learnkotlin.databinding.ActivityInfoBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val memberOneCardView = binding.memberoneCardview
        val memberTwoCardView = binding.membertwoCardview
        val backButton = binding.backButton

        val instaLink1 = binding.memberoneInstaTextview
        val instaLink2 = binding.membertwoInstaTextview
        val gitLink1 = binding.memberoneGithubTextview
        val gitLink2 = binding.membertwoGithubTextview

        instaLink1.movementMethod = LinkMovementMethod.getInstance()
        instaLink2.movementMethod = LinkMovementMethod.getInstance()

        gitLink1.movementMethod = LinkMovementMethod.getInstance()
        gitLink2.movementMethod = LinkMovementMethod.getInstance()

        lifecycleScope.launch {
            delay(400)
            MyAnimations.myAnimate(memberOneCardView, MyAnimations.slideInRight, baseContext)
            delay(400)
            MyAnimations.myAnimate(memberTwoCardView, MyAnimations.slideInLeft, baseContext)
        }

        backButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
    }
}