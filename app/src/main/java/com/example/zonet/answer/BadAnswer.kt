package com.example.zonet.answer

import android.view.animation.AnimationUtils
import androidx.lifecycle.MutableLiveData
import com.example.zonet.R
import com.google.android.material.button.MaterialButton

class BadAnswer(answer: String, private val materialButton: MaterialButton, isAnswerFound: MutableLiveData<Boolean>) : Answer(answer, materialButton) {
    init {
        materialButton.setOnClickListener { onAnswerClicked(isAnswerFound) }
    }

    override fun onAnswerClicked(isAnswerFound: MutableLiveData<Boolean>) {
        materialButton.startAnimation(AnimationUtils.loadAnimation(materialButton.context, R.anim.shakre_animation))
        isAnswerFound.value = false
    }

}
