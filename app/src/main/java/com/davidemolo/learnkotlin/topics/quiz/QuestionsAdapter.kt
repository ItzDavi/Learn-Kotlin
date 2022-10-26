package com.davidemolo.learnkotlin.topics.quiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidemolo.learnkotlin.R

class QuestionsAdapter(private val mList: List<QuestionViewModel>, var context: Context) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.question.text = item.question
        holder.answer1RadioButton.text = item.answer1
        holder.answer2RadioButton.text = item.answer2
        holder.answer3RadioButton.text = item.answer3
        holder.answer4RadioButton.text = item.answer4
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val question: TextView = itemView.findViewById(R.id.question_textview)
        val answer1RadioButton : RadioButton = itemView.findViewById(R.id.answer1_button)
        val answer2RadioButton : RadioButton = itemView.findViewById(R.id.answer2_button)
        val answer3RadioButton : RadioButton = itemView.findViewById(R.id.answer3_button)
        val answer4RadioButton : RadioButton = itemView.findViewById(R.id.answer4_button)
    }

    companion object {
        fun getCheckedAnswer(radioGroup: RadioGroup) : String {
            val checked = radioGroup.checkedRadioButtonId

            return checked.toString()
        }
    }
}