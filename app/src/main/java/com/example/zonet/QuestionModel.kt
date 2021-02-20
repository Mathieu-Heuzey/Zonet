package com.example.zonet

import com.google.gson.annotations.SerializedName

class QuestionList(val list: List<QuestionModel>)

class QuestionModel(
    @SerializedName("titre") val titre: String,
    @SerializedName("image") val image: String,
    @SerializedName("question") val question: String,
    @SerializedName("good") val goodAnswer: String,
    @SerializedName("bad") val badAnswer: BadAnswer
)

class BadAnswer(
    @SerializedName("1") val first: String,
    @SerializedName("2") val second: String,
    @SerializedName("3") val third: String
)
