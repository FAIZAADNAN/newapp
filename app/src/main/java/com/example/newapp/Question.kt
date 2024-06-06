package com.example.newapp

data class Question(
    val id: Int,
    val question: String,
    val image: Int?,  // Use nullable Int for image resource ID
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
