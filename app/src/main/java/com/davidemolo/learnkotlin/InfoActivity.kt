package com.davidemolo.learnkotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import com.davidemolo.learnkotlin.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val instaLink1 = binding.memberoneInstaTextview
        val instaLink2 = binding.membertwoInstaTextview
        val gitLink1 = binding.memberoneGithubTextview
        val gitLink2 = binding.membertwoGithubTextview


        instaLink1.movementMethod = LinkMovementMethod.getInstance()
        instaLink2.movementMethod = LinkMovementMethod.getInstance()

        gitLink1.movementMethod = LinkMovementMethod.getInstance()
        gitLink2.movementMethod = LinkMovementMethod.getInstance()


        val backButton = binding.backButton
        backButton.setOnClickListener {
            finish()
        }
    }
}