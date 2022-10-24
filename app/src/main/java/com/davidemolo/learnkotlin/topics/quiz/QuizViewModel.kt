package com.davidemolo.learnkotlin.topics.quiz

class QuizViewModel (
    val topic : String,
    private val questions : List<QuestionViewModel>
) {
    private var score = 0
    var currentQuestion = 0
    var answered = false

    fun getQuestion() : QuestionViewModel {
        return questions[currentQuestion]
    }

    fun nextQuestion() {
        currentQuestion++
    }

    fun increaseScore() {
        score++
    }

    fun resetScore() {
        score = 0
    }

    fun resetCurrentQuestion() {
        currentQuestion = 0
    }

    fun resetAnswered() {
        answered = false
    }


    fun resetQuiz() {
        resetScore()
        resetCurrentQuestion()
        resetAnswered()
    }

    fun isLastQuestion() : Boolean {
        return currentQuestion == questions.size - 1
    }

    fun isAnswered() : Boolean {
        return answered
    }

    fun setAnswered() {
        answered = true
    }
}
