package com.example.zonet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.zonet.databinding.QuizzActivityBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: QuizzActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = QuizzActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val questionsList = QuizAPI().getQuestionList(this)
        val pagerAdapter = QuestionSlidePagerAdapter(this, questionsList)

        binding.pager.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if (binding.pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.pager.currentItem = binding.pager.currentItem - 1
        }
    }

    private inner class QuestionSlidePagerAdapter(
        fragment: FragmentActivity,
        private val questionsList: Array<QuestionModel>
    ) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = questionsList.size

        override fun createFragment(position: Int): Fragment = QuestionFragment()
    }
}
