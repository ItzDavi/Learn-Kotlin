package com.davidemolo.learnkotlin.topics.lessons

import androidx.lifecycle.ViewModel

class LessonViewModel(
    val lessonNumber: String,
    val lessonTitle: String,
    //Aggiunto questo
    val lessonText: String,
    ) : ViewModel()