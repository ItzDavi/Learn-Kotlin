package com.davidemolo.learnkotlin.topics.lessons

import androidx.lifecycle.ViewModel

class LessonViewModel(
    val lessonNumber: String,
    val lessonTitle: String,
    //val lessonShortDescription: String,
    //val lessonDescription: String,
    val firstParagraph: String,
    val secondParagraph: String,
    ) : ViewModel()