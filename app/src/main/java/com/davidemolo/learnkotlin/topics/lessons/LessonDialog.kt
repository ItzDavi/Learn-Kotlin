package com.davidemolo.learnkotlin.topics.lessons

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.davidemolo.learnkotlin.MyAnimations
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
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.95).toInt()
        dialog!!.window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        dialog!!.window?.statusBarColor = requireContext().getColor(R.color.material_a2_blue)

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
        val lessonParagraph1TextView = dialog!!.findViewById<TextView>(R.id.lesson_text_paragraph1_textview)
        val lessonParagraph2TextView = dialog!!.findViewById<TextView>(R.id.lesson_text_paragraph2_textview)
        val lessonContentImage = dialog!!.findViewById<ImageView>(R.id.lesson_content_image_view)

        nextLessonButton.setOnClickListener {
            dialogScrollView.fullScroll(ScrollView.FOCUS_UP)

            MyAnimations.myAnimate(lessonTitleTextView, MyAnimations.fastFadeOut, requireContext(), View.INVISIBLE)
            MyAnimations.myAnimate(lessonParagraph1TextView, MyAnimations.fastFadeOut, requireContext(), View.INVISIBLE)
            MyAnimations.myAnimate(lessonParagraph2TextView, MyAnimations.fastFadeOut, requireContext(), View.INVISIBLE)
            MyAnimations.myAnimate(lessonContentImage, MyAnimations.fastFadeOut, requireContext(), View.INVISIBLE)

            currentPos++
            if (currentPos < lessonData.size) {
                lifecycleScope.launch {
                    delay(300)
                    loadLesson(lessonData[currentPos])

                    MyAnimations.myAnimate(lessonTitleTextView, MyAnimations.fastFadeIn, requireContext())
                    MyAnimations.myAnimate(lessonParagraph1TextView, MyAnimations.fastFadeIn, requireContext())
                    MyAnimations.myAnimate(lessonParagraph2TextView, MyAnimations.fastFadeIn, requireContext())
                    MyAnimations.myAnimate(lessonContentImage, MyAnimations.fastFadeIn, requireContext())

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
        val lessonParagraph1TextView = dialog!!.findViewById<TextView>(R.id.lesson_text_paragraph1_textview)
        val lessonParagraph2TextView = dialog!!.findViewById<TextView>(R.id.lesson_text_paragraph2_textview)
        val lessonContentImage = dialog!!.findViewById<ImageView>(R.id.lesson_content_image_view)

        lessonTitleTextView.text = lessonData.lessonTitle
        lessonParagraph1TextView.text = lessonData.firstParagraph
        lessonParagraph2TextView.text = lessonData.secondParagraph
        lessonContentImage.setImageDrawable(lessonData.contentImage)
    }
}