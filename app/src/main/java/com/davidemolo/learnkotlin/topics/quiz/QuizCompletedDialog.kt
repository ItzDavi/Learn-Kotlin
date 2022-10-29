package com.davidemolo.learnkotlin.topics.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.davidemolo.learnkotlin.MyAnimations
import com.davidemolo.learnkotlin.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizCompletedDialog : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.custom_blue_background);
        return inflater.inflate(R.layout.quiz_complete_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.95).toInt()
        dialog!!.window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        dialog!!.window?.statusBarColor = requireContext().getColor(R.color.material_a2_blue)

        dialog!!.window?.setLayout(width, height)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton : AppCompatButton = dialog!!.findViewById(R.id.close_dialog_button)

        val checkImageView : ImageView = dialog!!.findViewById(R.id.complete_tick_imageview)
        val completeTextView : TextView = dialog!!.findViewById(R.id.complete_quiz_textview)
        val complete2TextView : TextView = dialog!!.findViewById(R.id.complete_quiz_textview2)

        val context = requireContext()

        lifecycleScope.launch {
            MyAnimations.myAnimate(checkImageView, MyAnimations.slideInRight, context)
            delay(400)
            MyAnimations.myAnimate(completeTextView, MyAnimations.slideInLeft, context)
            delay(600)
            MyAnimations.myAnimate(complete2TextView, MyAnimations.slideInRight, context)
            delay(600)
            MyAnimations.myAnimate(closeButton, MyAnimations.slideInUp, context)
        }

        closeButton.setOnClickListener {
            dialog!!.dismiss()
        }
    }
}