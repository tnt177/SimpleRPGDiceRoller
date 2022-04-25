package com.example.simplerpgdiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.example.simplerpgdiceroller.databinding.ActivityAboutBinding

class about : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mTextView = findViewById<TextView>(R.id.textView14)

        mTextView.movementMethod = LinkMovementMethod.getInstance()
    }
}