package com.example.zonet

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zonet.databinding.MainActivityBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Paths

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.play.setOnClickListener {
            val intent = Intent(applicationContext, QuizzActivity::class.java)
            startActivity(intent)
        }
    }
}
