package com.davidemolo.learnkotlin.topics.lessons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.R

class LessonAdapter(private val mList: List<LessonViewModel>, var context: Context) : RecyclerView.Adapter<LessonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lesson_list_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        "${item.lessonNumber}. ${item.lessonTitle}".also { holder.lessonTextView.text = it }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lessonTextView: TextView = itemView.findViewById(R.id.lesson_title_textview)
    }
}