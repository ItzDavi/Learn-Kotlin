package com.davidemolo.learnkotlin.topics.lessons

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.databinding.FragmentLessonsBinding
import com.davidemolo.learnkotlin.R
import com.davidemolo.learnkotlin.topics.quiz.QuizFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TOPIC = "topic"
private var topic = "Kotlin"

class LessonsFragment : Fragment() {
    private var _lessonsBinding: FragmentLessonsBinding? = null
    private val lessonsBinding get() = _lessonsBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _lessonsBinding = FragmentLessonsBinding.inflate(inflater, container, false)
        return lessonsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lessonsRecyclerView = lessonsBinding.lessonsRecyclerview
        val topicQuizButton = lessonsBinding.topicQuizButton

        lessonsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        lessonsBinding.lessonsTextview.text = topic

        lifecycleScope.launch {
            loadLessons(lessonsRecyclerView, topic)
        }

        topicQuizButton.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                .replace(
                    R.id.lessons_home_fragment,
                    QuizFragment.newInstance(topic)
                ).commitNow()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getString(TOPIC)?.let {
            topic = it
        }
    }

    private fun loadLessons(lessonsRecyclerView: RecyclerView, topic: String) {
        val lessonsData = ArrayList<LessonViewModel>()

        when(topic) {
            "Kotlin" -> {
                lessonsData.add(LessonViewModel( "01", "What is Kotlin ?", getString(R.string.kotlin_1_a), getString(R.string.kotlin_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_kotlin_1)!!))
                lessonsData.add(LessonViewModel( "02", "Project creation", getString(R.string.kotlin_2_a), getString(R.string.kotlin_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_kotlin_2jpg)!!))
            }

            "Variables" -> {
                lessonsData.add(LessonViewModel( "01", "Data types", getString(R.string.variables_1_a), getString(R.string.variables_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_variables_1)!!))
                lessonsData.add(LessonViewModel( "01", "Val, var",getString(R.string.variables_2_a), getString(R.string.variables_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_variables_2)!!))
                lessonsData.add(LessonViewModel( "02", "Lateinit", getString(R.string.variables_3_a), getString(R.string.variables_3_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_variables_3)!!))
            }

            "Activities" -> {
                lessonsData.add(LessonViewModel( "01", "What is an acvitity ?",getString(R.string.activities_1_a), getString(R.string.activities_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_activities_1)!!))
                lessonsData.add(LessonViewModel( "02", "Lifecycles",getString(R.string.activities_2_a), getString(R.string.activities_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_activities_2)!!))
                lessonsData.add(LessonViewModel( "03", "Activities structure",getString(R.string.activities_3_a), getString(R.string.activities_3_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_activities_3)!!))
            }

            "Conditions" -> {
                lessonsData.add(LessonViewModel( "01", "If else",getString(R.string.conditions_1_a), getString(R.string.conditions_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_conditions_1)!!))
                lessonsData.add(LessonViewModel( "02", "When",getString(R.string.conditions_2_a), getString(R.string.conditions_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_conditions_2)!!))
                lessonsData.add(LessonViewModel( "03", "? x : y",getString(R.string.conditions_3_a), getString(R.string.conditions_3_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_conditions_3)!!))
            }

            "Loops" -> {
                lessonsData.add(LessonViewModel("01", "For, for in", getString(R.string.loops_1_a), getString(R.string.loops_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_loops_1)!!))
                lessonsData.add(LessonViewModel("02", "While, do while",getString(R.string.loops_2_a), getString(R.string.loops_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_loops_2)!!))
            }

            "Layouts" -> {
                lessonsData.add(LessonViewModel("01", "Basic UI concepts",getString(R.string.layouts_1_a), getString(R.string.layouts_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_layouts_1)!!))
                lessonsData.add(LessonViewModel("02", "XMLs",getString(R.string.layouts_2_a), getString(R.string.layouts_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_layouts_2)!!))
                lessonsData.add(LessonViewModel("03", "Constraints and Linear layouts",getString(R.string.layouts_3_a), getString(R.string.layouts_3_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_layouts_3)!!))
            }

            "Events" -> {
                lessonsData.add(LessonViewModel("01", "Listeners",getString(R.string.events_1_a), getString(R.string.events_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_events_1)!!))
                lessonsData.add(LessonViewModel("02", "Intents",getString(R.string.events_2_a), getString(R.string.events_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_events_2)!!))
            }

            "WebView" -> {
                lessonsData.add(LessonViewModel("01", "What is a WebView ?",getString(R.string.webview_1_a), getString(R.string.webview_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_webview_1)!!))
                lessonsData.add(LessonViewModel("02", "How to implement a WebView",getString(R.string.webview_2_a), getString(R.string.webview_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_webview_2)!!))
                lessonsData.add(LessonViewModel("03", "Why not to implement a WebView",getString(R.string.webview_3_a), getString(R.string.webview_3_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_webview_3)!!))
            }

            "Fragments" -> {
                lessonsData.add(LessonViewModel("01", "What is a fragment ?",getString(R.string.fragments_1_a), getString(R.string.fragments_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_fragments_1)!!))
                lessonsData.add(LessonViewModel("02", "Fragments lifecycle",getString(R.string.fragments_2_a), getString(R.string.fragments_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_fragments_2)!!))
                lessonsData.add(LessonViewModel("03", "Add two fragments",getString(R.string.fragments_3_a), getString(R.string.fragments_3_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_fragments_3)!!))
            }

            "ViewBinding" -> {
                lessonsData.add(LessonViewModel("01", "What is ViewBinding ?",getString(R.string.viewbinding_1_a), getString(R.string.viewbinding_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_viewbinding_1)!!))
                lessonsData.add(LessonViewModel("02", "Why and how to implement it",getString(R.string.viewbinding_2_a), getString(R.string.viewbinding_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_viewbinding_2)!!))
            }

            "Animations" -> {
                lessonsData.add(LessonViewModel("01", "What are animations ?",getString(R.string.animations_1_a), getString(R.string.animations_1_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_animation_1)!!))
                lessonsData.add(LessonViewModel("02", "Common animations",getString(R.string.animations_2_a), getString(R.string.animations_2_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_animations_2)!!))
                lessonsData.add(LessonViewModel("03", "Animation or transaction ?",getString(R.string.animations_3_a), getString(R.string.animations_3_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_animations_3)!!))
                lessonsData.add(LessonViewModel("04", "XML examples",getString(R.string.animations_4_a), getString(R.string.animations_4_b), AppCompatResources.getDrawable(requireContext(), R.drawable.lesson_animations_4)!!))

            }
        }

        lessonsRecyclerView.adapter = LessonAdapter(lessonsData, requireContext(), activity?.supportFragmentManager!!)
    }

    companion object {
        @JvmStatic
        fun newInstance(topic: String) = LessonsFragment().apply{
            arguments = Bundle().apply {
                putString(TOPIC, topic)
            }
        }
    }
}