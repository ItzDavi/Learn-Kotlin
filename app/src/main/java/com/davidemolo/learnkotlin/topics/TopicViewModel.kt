package com.davidemolo.learnkotlin.topics

import androidx.lifecycle.ViewModel

class TopicViewModel(
    val topicTitle: String,
    //TODO prima o poi mettere topicTime float cosi da fare 0.1 ore, 1.3 ore ecc
    val topicTime: Int,
    val topicLessons: Int,
    val topicDifficulty: Int,
    val topicLanguage: String
    ) : ViewModel()