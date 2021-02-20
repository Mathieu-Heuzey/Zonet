package com.example.zonet

import android.content.Context
import com.google.gson.GsonBuilder
import java.io.IOException

class QuizAPI {

    fun getQuestionList(context: Context): Array<QuestionModel> {
        val content = getJsonDataFromAsset(context)
        return decodeJsonFromFile2(content!!)
    }

    private inline fun <reified T> decodeJsonFromFile2(path: String): T {
        return GsonBuilder().create().fromJson(path, T::class.java)
    }

    private fun getJsonDataFromAsset(context: Context): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open("quizz2.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}
