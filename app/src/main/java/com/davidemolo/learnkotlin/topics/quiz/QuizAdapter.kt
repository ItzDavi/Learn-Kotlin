package com.davidemolo.learnkotlin.topics.quiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.R

class QuizAdapter(private val mList: List<QuestionViewModel>, var context: String) : RecyclerView.Adapter<QuizAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.questionTextView.text = item.question
        holder.answer1TextView.text = item.answer1
        holder.answer2TextView.text = item.answer2
        holder.answer3TextView.text = item.answer3
        holder.answer4TextView.text = item.answer4
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.question_textview)
        val answer1TextView: TextView = itemView.findViewById(R.id.answer1_button)
        val answer2TextView: TextView = itemView.findViewById(R.id.answer2_button)
        val answer3TextView: TextView = itemView.findViewById(R.id.answer3_button)
        val answer4TextView: TextView = itemView.findViewById(R.id.answer4_button)
    }
}
