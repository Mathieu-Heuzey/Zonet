package com.example.zonet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.zonet.databinding.QuizzActivityBinding

class QuizzActivity : AppCompatActivity() {
    private lateinit var binding: QuizzActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuizzActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val question2 = QuizzAPI.create(this).getQuestion2(this)
        val pagerAdapter = QuestionSlidePagerAdapter(this)
        binding.pager.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if (binding.pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            binding.pager.currentItem = binding.pager.currentItem - 1
        }
    }
    private inner class QuestionSlidePagerAdapter(fa : FragmentActivity): FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 10

        override fun createFragment(position: Int): Fragment = QuestionFragment()
    }
}
