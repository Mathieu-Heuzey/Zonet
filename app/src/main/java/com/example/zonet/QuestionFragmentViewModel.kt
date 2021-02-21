package com.example.zonet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zonet.answer.Answer
import com.example.zonet.answer.BadAnswer
import com.example.zonet.answer.GoodAnswer
import com.google.android.material.button.MaterialButton

class QuestionFragmentViewModel(btnList: MutableList<MaterialButton>, questionModel: QuestionModel) : ViewModel() {

    val answers = mutableListOf<Answer>()
    private val isAnswerFound = MutableLiveData<Boolean>()

    fun getState() : MutableLiveData<Boolean> = isAnswerFound

    init {
        isAnswerFound.value = false
        bindAnswerToBtn(btnList, questionModel)
    }

    private fun bindAnswerToBtn(btnList: MutableList<MaterialButton>, questionModel: QuestionModel) {
        questionModel.answer.forEach {
            if (it.good) {
                val randomBtn = btnList.random()
                btnList.remove(randomBtn)
                answers.add(GoodAnswer(it.answer, randomBtn, isAnswerFound))
            } else {
                val randomBtn = btnList.random()
                btnList.remove(randomBtn)
                answers.add(BadAnswer(it.answer, randomBtn, isAnswerFound))
            }
        }
    }
}
