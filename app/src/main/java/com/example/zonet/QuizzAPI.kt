package com.example.zonet

import android.content.Context
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream

class QuizzAPI {
    companion object;

    fun getQuestion2(context: Context): Array<QuestionModel> {
        val content = getJsonDataFromAsset(context, "quizz2.json")
        return decodeJsonFromFile2(content!!)
    }

    private inline fun <reified T> decodeJsonFromFile2(path: String): T {
        return GsonBuilder().create().fromJson(path, T::class.java)
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}

fun QuizzAPI.Companion.create(c: Context): QuizzAPI {
    return QuizzAPI()
}
