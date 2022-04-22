package com.example.simplerpgdiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplerpgdiceroller.databinding.ActivityInstructionsBinding

class instructions : AppCompatActivity() {

    private lateinit var binding: ActivityInstructionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}