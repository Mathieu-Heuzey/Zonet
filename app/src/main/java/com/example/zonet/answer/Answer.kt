package com.example.zonet.answer

import com.google.android.material.button.MaterialButton

abstract class Answer(answer: String, materialButton: MaterialButton) {
    init {
        materialButton.text = answer
    }

    abstract fun onAnswerClicked()
}
