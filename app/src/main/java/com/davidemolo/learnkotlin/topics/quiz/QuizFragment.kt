package com.davidemolo.learnkotlin.topics.quiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.R
import com.davidemolo.learnkotlin.databinding.FragmentQuizBinding
import com.davidemolo.learnkotlin.topics.TopicViewModel
import com.davidemolo.learnkotlin.topics.lessons.LessonViewModel
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

        lifecycleScope.launch {
            loadQuestions()
        }

        quizBinding.quizTopicTitleTextview.text = topic

        val topicData = loadTopicInfo(topic)
        val questionsData = loadQuestions()

        "${topicData?.topicDifficulty} / 5".also { quizBinding.quizDifficultyTextview.text = it }

        val startQuizButton = quizBinding.checkAnswersButton
        startQuizButton.setOnClickListener {
            QuizDialog(questionsData).show(parentFragmentManager, "QuestionLessonDialog")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getString(TOPIC)?.let {
            topic = it
        }
    }

    private fun loadTopicInfo(topic: String) : TopicViewModel? {
        var topicData: TopicViewModel ?= null

        when (topic) {
            "Kotlin" -> {
                topicData = TopicViewModel("Kotlin", 1, 2, 1, "English")
            }

            "Variables" -> {
                topicData = TopicViewModel("Variables", 2, 3, 1, "English")
            }

            "Activities" -> {
                topicData = TopicViewModel("Activities", 3, 3, 2, "English")
            }

            "Conditions" -> {
                topicData = TopicViewModel("Conditions", 1, 3, 2, "English")
            }

            "Loops" -> {
                topicData = TopicViewModel("Loops", 1, 2, 2, "English")
            }

            "Layouts" -> {
                topicData = TopicViewModel("Layouts", 2, 3, 3, "English")
            }

            "Events" -> {
                topicData = TopicViewModel("Events", 2, 2, 2, "English")
            }

            "WebView" -> {
                topicData = TopicViewModel("WebView", 1, 3, 1, "English")
            }

            "Fragments" -> {
                topicData = TopicViewModel("Fragments", 2, 3, 4, "English")
            }

            "ViewBinding" -> {
                topicData = TopicViewModel("ViewBinding", 1, 2, 3, "English")
            }

            "Animations" -> {
                topicData = TopicViewModel("Animations", 2, 4, 3, "English")
            }
        }

        return topicData
    }

    private fun loadQuestions() : ArrayList<QuestionViewModel> {
        val questions = ArrayList<QuestionViewModel>()

        when (topic) {
            "Kotlin" -> {
                questions.add(QuestionViewModel(
                        "What is Kotlin ?",
                        "A programming language",
                        "A framework",
                        "A library",
                        "A compiler",
                        "A programming language"))

                questions.add(QuestionViewModel(
                        "What are data types in Kotlin ?",
                        "Different types of data a variable can store",
                        "Types of Kotlin strings",
                        "Only numbers are types in Kotlin",
                        "Bit, Bytes and Megabytes",
                        "Different types of data a variable can store"))

                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "Variables" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "Activities" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "Conditions" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "Loops" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "Layout" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "Events" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "WebView" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "Fragments" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "ViewBinding" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
            "Animations" -> {
                questions.add(QuestionViewModel(
                    "What is Kotlin ?",
                    "A programming language",
                    "A framework",
                    "A library",
                    "A compiler",
                    "A programming language"))

                questions.add(QuestionViewModel(
                    "What are data types in Kotlin ?",
                    "Different types of data a variable can store",
                    "Types of Kotlin strings",
                    "Only numbers are types in Kotlin",
                    "Bit, Bytes and Megabytes",
                    "Different types of data a variable can store"))
            }
        }

        return questions
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