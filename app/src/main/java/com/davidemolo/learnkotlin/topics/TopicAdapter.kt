package com.davidemolo.learnkotlin.topics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.R

class TopicAdapter(private val mList: List<TopicViewModel>, var context: Context) : RecyclerView.Adapter<TopicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topic_cardview_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.topicTitleTextView.text = item.topicTitle
        "${item.topicTime} Hours".also { holder.topicTimeTextView.text = it }
        "${item.topicLessons} Lessons".also { holder.topicLessonsTextView.text = it }
        "${item.topicDifficulty} / 5".also { holder.topicDifficultyTextView.text = it }
        holder.topicLanguageTextView.text = item.topicLanguage
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicTitleTextView: TextView = itemView.findViewById(R.id.cardview_topic_title)
        val topicTimeTextView: TextView = itemView.findViewById(R.id.cardview_topic_time_textview)
        val topicLessonsTextView: TextView = itemView.findViewById(R.id.card_view_topic_lessons_textview)
        val topicDifficultyTextView: TextView = itemView.findViewById(R.id.cardview_topic_difficulty_textview)
        val topicLanguageTextView: TextView = itemView.findViewById(R.id.cardview_topic_language_textview)
    }
}