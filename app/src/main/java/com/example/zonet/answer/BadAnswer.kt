package com.example.zonet.answer

import com.google.android.material.button.MaterialButton

class BadAnswer(answer: String, materialButton: MaterialButton) : Answer(answer, materialButton) {
    override fun onAnswerClicked() {
    }

}
