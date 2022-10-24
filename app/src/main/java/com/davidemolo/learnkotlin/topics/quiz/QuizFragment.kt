package com.davidemolo.learnkotlin.topics.quiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.databinding.FragmentQuizBinding
import kotlinx.coroutines.launch

private const val TOPIC = "topic"
private var topic = "Kotlin"

class QuizFragment : Fragment() {
    private var _quizBinding: FragmentQuizBinding? = null
    private val quizBinding get() = _quizBinding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _quizBinding = FragmentQuizBinding.inflate(inflater, container, false)
        return quizBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val questionsRecyclerView = quizBinding.questionsRecyclerview

        questionsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        quizBinding.quizTitleTextview.text = topic

        lifecycleScope.launch {
            loadQuestions(questionsRecyclerView, topic)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getString(TOPIC)?.let {
            topic = it
        }
    }

    private fun loadQuestions(questionsRecyclerView: RecyclerView, topic: String) {
        val questions = mutableListOf<QuestionViewModel>()

        questions.add(
            QuestionViewModel(
                "What is Kotlin ?",
                "A programming language",
                "A framework",
                "A library",
                "A compiler",
                "A programming language"
            )
        )

        questions.add(
            QuestionViewModel(
                "What are data types in Kotlin ?",
                "Different types of data a variable can store",
                "Types of Kotlin strings",
                "Only numbers are types in Kotlin",
                "Bit, Bytes and Megabytes",
                "Different types of data a variable can store"
            )
        )

        questions.add(
            QuestionViewModel(
                "What is the name of the Kotlin compiler for Android?",
                "Kotlin",
                "Kotlin Compiler",
                "Kotlin Compiler for JVM",
                "Kotlin Compiler for Android",
                "Kotlin Compiler for Android"
            )
        )

        questions.add(
            QuestionViewModel(
                "What is the name of the Kotlin compiler for JavaScript?",
                "Kotlin",
                "Kotlin Compiler",
                "Kotlin Compiler for JVM",
                "Kotlin Compiler for Android",
                "Kotlin Compiler for JavaScript"
            )
        )

        questions.add(
            QuestionViewModel(
                "What is the name of the Kotlin compiler for Native?",
                "Kotlin",
                "Kotlin Compiler",
                "Kotlin Compiler for JVM",
                "Kotlin Compiler for Android",
                "Kotlin Compiler for Native"
            )
        )

        questions.add(
            QuestionViewModel(
                "What is the name of the Kotlin compiler for iOS?",
                "Kotlin",
                "Kotlin Compiler",
                "Kotlin Compiler for JVM",
                "Kotlin Compiler for Android",
                "Kotlin Compiler for iOS"
            )
        )

        questions.add(
            QuestionViewModel(
                "What is the name of the Kotlin compiler for Windows?",
                "Kotlin",
                "Kotlin Compiler",
                "Kotlin Compiler for JVM",
                "Kotlin Compiler for Android",
                "Kotlin Compiler for Windows"
            )
        )

        questions.add(
            QuestionViewModel(
                "What is the name of the Kotlin compiler for Linux?",
                "Kotlin",
                "Kotlin Compiler",
                "Kotlin Compiler for JVM",
                "Kotlin Compiler for Android",
                "Kotlin Compiler for Linux"
            )
        )

        questions.add(
            QuestionViewModel(
                "What is the name of the Kotlin compiler for macOS?",
                "Kotlin",
                "Kotlin Compiler",
                "Kotlin Compiler for JVM",
                "Kotlin Compiler for Android",
                "Kotlin Compiler for macOS"
            )
        )

        questionsRecyclerView.adapter = QuizAdapter(questions, topic)
    }

    companion object {
        @JvmStatic
        fun newInstance(topic: String) =
            QuizFragment().apply {
                arguments = Bundle().apply {
                   putString(TOPIC, topic)
                }
            }
    }
}