package com.example.viewmodeldemo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.viewmodeldemo.R
import com.example.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        mainViewModel.getAllStudents()
        initObservers()
    }

    private fun initObservers() {
        mainViewModel.students.observe(this) {
            Log.e("Students", it.toString())

            binding.allStudents.text = it.toString()
        }
    }
}