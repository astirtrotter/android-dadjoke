package com.tcs.dadjoke.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tcs.dadjoke.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)
    }
}