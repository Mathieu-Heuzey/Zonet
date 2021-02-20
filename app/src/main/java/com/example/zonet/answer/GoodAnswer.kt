package com.example.zonet.answer

import androidx.lifecycle.MutableLiveData
import com.google.android.material.button.MaterialButton

class GoodAnswer(answer: String, materialButton: MaterialButton, isAnswerFound: MutableLiveData<Boolean>) :
    Answer(answer, materialButton) {
    init {
        materialButton.setOnClickListener {
            onAnswerClicked(isAnswerFound)
        }
    }

    override fun onAnswerClicked(isAnswerFound: MutableLiveData<Boolean>) {
        isAnswerFound.value = true
    }

}
