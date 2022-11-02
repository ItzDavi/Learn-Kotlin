package com.davidemolo.learnkotlin.topics.quiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.davidemolo.learnkotlin.R
import com.google.android.material.button.MaterialButton

class QuizDialog(private val quizData: ArrayList<QuestionViewModel>) : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.custom_blue_background);
        return inflater.inflate(R.layout.quiz_dialog_layout, container, false)
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

        val quizRecyclerView: RecyclerView = dialog!!.findViewById(R.id.questions_recyclerview)
        quizRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val quizAdapter = QuestionsAdapter(quizData, requireContext())
        quizRecyclerView.adapter = quizAdapter

        val backButton: ImageView = dialog!!.findViewById(R.id.back_button_imageview)
        backButton.setOnClickListener {
            dialog!!.dismiss()
        }

        val checkAnswersButton: AppCompatButton = dialog!!.findViewById(R.id.questions_submit_button)
        checkAnswersButton.setOnClickListener {
            QuizCompletedDialog().show(parentFragmentManager, "QuizCompletedDialog")
            dialog!!.dismiss()
        }
    }
}