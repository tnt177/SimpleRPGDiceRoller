package com.example.simplerpgdiceroller

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.simplerpgdiceroller.databinding.ActivityDiceJailBinding

class dice_jail : AppCompatActivity() {

    private lateinit var binding: ActivityDiceJailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceJailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectButton.setOnClickListener{

            var choice = arrayOf("d4", "d6", "d8", "d10", "d12", "d20", "d100")
            val builder = AlertDialog.Builder(binding.root.context)
            val title = getString(R.string.Click)

            builder
                .setSingleChoiceItems(choice, 8) { dialogInterface: DialogInterface,
                                                   position: Int ->
                    Toast.makeText(
                        applicationContext, getString(R.string.you_selected) + " " + choice[position],
                        Toast.LENGTH_LONG
                    ).show()

                    if (choice[position] == "d4") {
                        binding.diceImageView.setImageResource(R.drawable.dice4)
                    } else if (choice[position] == "d6") {
                        binding.diceImageView.setImageResource(R.drawable.dice6)
                    } else if (choice[position] == "d8") {
                        binding.diceImageView.setImageResource(R.drawable.dice8)
                    } else if (choice[position] == "d10") {
                        binding.diceImageView.setImageResource(R.drawable.dice10)
                    } else if (choice[position] == "d12") {
                        binding.diceImageView.setImageResource(R.drawable.dice12)
                    } else if (choice[position] == "d20") {
                        binding.diceImageView.setImageResource(R.drawable.dice20)
                    } else if (choice[position] == "d100") {
                        binding.diceImageView.setImageResource(R.drawable.dice100)
                    }
                }
                .setTitle(Html.fromHtml(title, Html.FROM_HTML_MODE_LEGACY))
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
    }
}