package com.example.simplerpgdiceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import com.example.simplerpgdiceroller.databinding.ActivityPreferencesBinding

class preferences : AppCompatActivity(),
    RadioGroup.OnCheckedChangeListener {

    private lateinit var binding: ActivityPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backgroundColorRadioGroup.setOnCheckedChangeListener(this)
    }

    override fun onStart() {
        super.onStart()

        val preferences =
            getSharedPreferences(getString(R.string.preferences_storage_name),
                Context.MODE_PRIVATE)

        val background = preferences.getString(getString(R.string.background_color_key),
        getString(R.string.background_color_dragon)
        )

        if (background.equals("dragon")) {
            binding.dragonRadioButton.isChecked = true
        } else if (background.equals("antique")) {
            binding.antiqueRadioButton.isChecked = true
        } else if (background.equals("forrest")) {
            binding.forestRadioButton.isChecked = true
        } else if (background.equals("gold")) {
            binding.goldRadioButton.isChecked = true
        } else if (background.equals("lavender")) {
            binding.lavenderRadioButton.isChecked = true
        } else if (background.equals("sandy")) {
            binding.sandyRadioButton.isChecked = true
        } else if (background.equals("silver")) {
            binding.silverRadioButton.isChecked = true
        }

    }

    override fun onCheckedChanged(radioGroup: RadioGroup?, buttonId: Int) {
        val preferences =
            getSharedPreferences(getString(R.string.preferences_storage_name),
            Context.MODE_PRIVATE)

        with(preferences.edit()) {
            if (buttonId == R.id.dragon_radioButton) {
                putString(getString(R.string.background_color_key), "dragon")
            } else if (buttonId == R.id.antique_radioButton) {
                putString(getString(R.string.background_color_key), "antique")
            } else if (buttonId == R.id.forest_radioButton) {
                putString(getString(R.string.background_color_key), "forrest")
            } else if (buttonId == R.id.gold_radioButton) {
                putString(getString(R.string.background_color_key), "gold")
            } else if (buttonId == R.id.lavender_radioButton) {
                putString(getString(R.string.background_color_key), "lavender")
            } else if (buttonId == R.id.sandy_radioButton) {
                putString(getString(R.string.background_color_key), "sandy")
            } else if (buttonId == R.id.silver_radioButton) {
                putString(getString(R.string.background_color_key), "silver")
            }
            apply()
        }
    }
}