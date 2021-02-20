package com.example.zonet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zonet.databinding.QuizzActivityBinding

class QuizzActivity : AppCompatActivity() {
    private lateinit var binding: QuizzActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuizzActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val question2 = QuizzAPI.create(this).getQuestion2(this)
    }
}
