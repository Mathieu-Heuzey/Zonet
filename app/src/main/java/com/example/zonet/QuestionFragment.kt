package com.example.zonet

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.zonet.databinding.QuestionFragmentBinding
import com.google.android.material.button.MaterialButton

class QuestionFragment(private val questionModel: QuestionModel) : Fragment() {

    private var binding: QuestionFragmentBinding? = null
    private lateinit var viewModel: QuestionFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = QuestionFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = binding ?: return

        val btnList = mutableListOf<MaterialButton>()
        btnList.apply {
            add(binding.first)
            add(binding.second)
            add(binding.third)
            add(binding.fourth)
        }

        viewModel = QuestionFragmentViewModel(btnList, questionModel)
        viewModel.getState().observe(viewLifecycleOwner) {
            if (it) {
                responseFound()
            } else
                responseNotFound()
        }
        setQuestionInfo()
    }

    private fun responseFound() {
        val binding = binding ?: return
        binding.validationAnimation.apply {
            visibility = View.VISIBLE
            playAnimation()
        }
    }

    private fun responseNotFound() {
        val binding = binding ?: return
        binding.validationAnimation.apply {
            visibility = View.GONE
        }
    }

    private fun setQuestionInfo() {
        binding?.title?.text = questionModel.titre

        val resources: Resources = context?.resources ?: return
        val resourceId: Int = resources.getIdentifier(
            questionModel.image, "drawable",
            context?.packageName
        )
        if (resourceId == 0) {
            throw  RuntimeException("Can't find drawable with name: " + questionModel.image)
        }
        val context2 = context
        val res = ContextCompat.getDrawable(context2!!, resourceId)
        binding?.image?.setImageDrawable(res)
        binding?.question?.text = questionModel.question

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
