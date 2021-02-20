package com.example.zonet

import com.google.gson.annotations.SerializedName

class QuestionModel(
    @SerializedName("titre") val titre: String,
    @SerializedName("image") val image: String,
    @SerializedName("question") val question: String,
    @SerializedName("answer") val answer: Array<Choice>
)

class Choice(
    @SerializedName("title") val answer: String,
    @SerializedName("isGood") val good: Boolean,
)
