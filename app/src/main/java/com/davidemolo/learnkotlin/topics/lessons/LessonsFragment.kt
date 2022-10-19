package com.davidemolo.learnkotlin.topics.lessons

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.databinding.FragmentLessonsBinding
import com.davidemolo.learnkotlin.R
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

        val lessonImage = activity?.findViewById<ImageView>(R.id.lessons_empty_background)
        val slideOutDownAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_out_down)
        val lessonsRecyclerView = lessonsBinding.lessonsRecyclerview

        lessonsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        lessonsBinding.lessonsTextview.text = topic

        /*if (lessonImage?.visibility == View.VISIBLE) {
            lessonImage.startAnimation(slideOutDownAnimation)
            lessonImage.visibility = View.GONE
        }*/

        lifecycleScope.launch {
            loadLessons(lessonsRecyclerView, topic)
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
                lessonsData.add(LessonViewModel( "01", "What is Kotlin ?"))
                lessonsData.add(LessonViewModel( "02", "Project creation"))
            }

            "Variables" -> {
                lessonsData.add(LessonViewModel( "01", "Data types"))
                lessonsData.add(LessonViewModel( "01", "Val, var"))
                lessonsData.add(LessonViewModel( "02", "Lateinit, private"))
            }

            "Activities" -> {
                lessonsData.add(LessonViewModel( "01", "What is an acvitity ?"))
                lessonsData.add(LessonViewModel( "02", "Lifecycles"))
                lessonsData.add(LessonViewModel( "03", "Activities structure"))
            }

            "Conditions" -> {
                lessonsData.add(LessonViewModel( "01", "If else"))
                lessonsData.add(LessonViewModel( "02", "When"))
                lessonsData.add(LessonViewModel( "03", "? x : y"))
            }

            "Loops" -> {
                lessonsData.add(LessonViewModel("01", "For, for in"))
                lessonsData.add(LessonViewModel("02", "While, do while"))
            }

            "Layouts" -> {
                lessonsData.add(LessonViewModel("01", "Basic UI concepts"))
                lessonsData.add(LessonViewModel("02", "XMLs"))
                lessonsData.add(LessonViewModel("03", "Constraints and Linear layouts"))
            }

            "Events" -> {
                lessonsData.add(LessonViewModel("01", "Listeners"))
                lessonsData.add(LessonViewModel("02", "Intents"))
            }

            "WebView" -> {
                lessonsData.add(LessonViewModel("01", "What is a WebView ?"))
                lessonsData.add(LessonViewModel("02", "How to implement a WebView"))
                lessonsData.add(LessonViewModel("03", "Why not to implement a WebView"))
            }

            "Fragments" -> {
                lessonsData.add(LessonViewModel("01", "What is a fragment ?"))
                lessonsData.add(LessonViewModel("02", "Fragments lifecycle"))
                lessonsData.add(LessonViewModel("03", "Add two fragments"))
            }

            "ViewBinding" -> {
                lessonsData.add(LessonViewModel("01", "What is ViewBinding ?"))
                lessonsData.add(LessonViewModel("02", "Why and how to implement it"))
            }

            "Animations" -> {
                lessonsData.add(LessonViewModel("01", "What are animations ?"))
                lessonsData.add(LessonViewModel("02", "Common animations"))
                lessonsData.add(LessonViewModel("03", "Animation or transaction ?"))
                lessonsData.add(LessonViewModel("04", "XML examples"))
            }
        }


        val adapter = LessonAdapter(lessonsData, requireContext())
        lessonsRecyclerView.adapter = adapter
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