package com.example.zonet.answer

import androidx.lifecycle.MutableLiveData
import com.google.android.material.button.MaterialButton

abstract class Answer(answer: String, materialButton: MaterialButton) {

    val btn: MaterialButton = materialButton

    init {
        materialButton.text = answer
    }

    abstract fun onAnswerClicked(isAnswerFound: MutableLiveData<Boolean>)
}
