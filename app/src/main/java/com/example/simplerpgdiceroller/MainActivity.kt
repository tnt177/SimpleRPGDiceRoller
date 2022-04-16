package com.example.simplerpgdiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplerpgdiceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var countDice = 0
    private var countMod = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.diceNumTextView.setText("Number of Dice: ${countDice}")
        binding.diceDownImageView.setOnClickListener{
            if (countDice >= 1) {
                countDice -= 1
                binding.diceNumTextView.setText("Number of Dice: ${countDice}")
            }
        }
        binding.diceNumTextView.setText("Number of Dice: ${countDice}")
        binding.diceUpImageView.setOnClickListener{
                countDice += 1
                binding.diceNumTextView.setText("Number of Dice: ${countDice}")
        }

        binding.modTextView.setText("Modifier +/-: ${countMod}")
        binding.modDownImageView.setOnClickListener{
            countMod -=1
            binding.modTextView.setText("Modifier +/-: ${countMod}")
        }

        binding.modTextView.setText("Modifier +/-: ${countMod}")
        binding.modUpImageView.setOnClickListener {
            countMod +=1
            binding.modTextView.setText("Modifier +/-: ${countMod}")
        }
    }
}