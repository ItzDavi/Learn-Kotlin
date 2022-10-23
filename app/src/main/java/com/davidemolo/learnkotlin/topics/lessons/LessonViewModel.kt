package com.davidemolo.learnkotlin.topics.lessons

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel

class LessonViewModel(
    val lessonNumber: String,
    val lessonTitle: String,
    val firstParagraph: String,
    val secondParagraph: String,
    val contentImage: Drawable
    ) : ViewModel()