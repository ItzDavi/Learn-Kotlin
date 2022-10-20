package com.davidemolo.learnkotlin.topics.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import com.davidemolo.learnkotlin.R

class LessonDialog(private val lessonData: List<LessonViewModel>, private val position: Int) : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.custom_blue_background);
        return inflater.inflate(R.layout.lesson_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.95).toInt()
        dialog!!.window?.setLayout(width, height)

        val nextLessonButton = dialog!!.findViewById<AppCompatButton>(R.id.next_lesson_button)
        val hideLessonButton = dialog!!.findViewById<ImageView>(R.id.hide_lesson_imageview)

        val lessonTitleTextView = dialog!!.findViewById<TextView>(R.id.lesson_textview)
        val lessonTextTextView = dialog!!.findViewById<TextView>(R.id.lesson_text_textview)

        loadLesson(lessonData[position], lessonTitleTextView, lessonTextTextView)

        nextLessonButton.setOnClickListener {
            dialog?.dismiss()
        }

        hideLessonButton.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun loadLesson(lessonData: LessonViewModel, lessonTitle: TextView, lessonText: TextView) {
        lessonTitle.text = lessonData.lessonTitle
    }
}