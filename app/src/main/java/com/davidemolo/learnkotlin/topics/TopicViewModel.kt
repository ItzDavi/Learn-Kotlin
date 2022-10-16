package com.davidemolo.learnkotlin.topics

import androidx.lifecycle.ViewModel

class TopicViewModel(
    val topicTitle: String,
    val topicTime: Int,
    val topicLessons: Int,
    val topicDifficulty: Int,
    val topicLanguage: String
    ) : ViewModel()