package com.davidemolo.learnkotlin.topics.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.davidemolo.learnkotlin.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LessonDialog(private val lessonData: List<LessonViewModel>, private var position: Int) : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.custom_blue_background);
        return inflater.inflate(R.layout.lesson_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.95).toInt()
        dialog!!.window?.setLayout(width, height)

        loadLesson(lessonData[position])
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextLessonButton = dialog!!.findViewById<AppCompatButton>(R.id.next_lesson_button)
        val hideLessonButton = dialog!!.findViewById<ImageView>(R.id.hide_lesson_imageview)

        val dialogScrollView = dialog!!.findViewById<ScrollView>(R.id.dialog_scrollview)
        var currentPos = position

        val lessonTitleTextView = dialog!!.findViewById<TextView>(R.id.lesson_textview)
        val lessonTextTextView = dialog!!.findViewById<TextView>(R.id.lesson_text_textview)

        nextLessonButton.setOnClickListener {
            lessonTitleTextView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fast_fade_out))
            lessonTitleTextView.visibility = View.INVISIBLE
            lessonTextTextView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fast_fade_out))
            lessonTextTextView.visibility = View.INVISIBLE

            currentPos++
            if (currentPos < lessonData.size) {
                lifecycleScope.launch {
                    delay(300)
                    loadLesson(lessonData[currentPos])

                    dialogScrollView.fullScroll(ScrollView.FOCUS_UP)

                    lessonTitleTextView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fast_fade_in))
                    lessonTitleTextView.visibility = View.VISIBLE
                    lessonTextTextView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fast_fade_in))
                    lessonTextTextView.visibility = View.VISIBLE
                }
            } else {
                Toast.makeText(requireContext(), "Topic completed!", Toast.LENGTH_SHORT).show()
                dialog!!.dismiss()
            }
        }

        hideLessonButton.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun loadLesson(lessonData: LessonViewModel) {
        val lessonTitleTextView = dialog!!.findViewById<TextView>(R.id.lesson_textview)
        //val lessonTextTextView = dialog!!.findViewById<TextView>(R.id.lesson_text_textview)

        lessonTitleTextView.text = lessonData.lessonTitle
    }
}