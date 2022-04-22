package com.example.simplerpgdiceroller

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.simplerpgdiceroller.databinding.ActivityMainBinding
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var countDice = 1
    private var countMod = 0
    private var header = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.diceNumTextView.setText(getString(R.string.number_of_dice) + " ${countDice}")
        binding.diceDownImageView.setOnClickListener {
            if (countDice >= 1) {
                countDice -= 1
                binding.diceNumTextView.setText(getString(R.string.number_of_dice) + " ${countDice}")
            }
        }
        binding.diceNumTextView.setText(getString(R.string.number_of_dice) + " ${countDice}")
        binding.diceUpImageView.setOnClickListener {
            countDice += 1
            binding.diceNumTextView.setText(getString(R.string.number_of_dice) + " ${countDice}")
        }

        binding.modTextView.setText(getString(R.string.modifier) + " ${countMod}")
        binding.modDownImageView.setOnClickListener {
            countMod -= 1
            binding.modTextView.setText(getString(R.string.modifier) + " ${countMod}")
        }

        binding.modTextView.setText(getString(R.string.modifier) + " ${countMod}")
        binding.modUpImageView.setOnClickListener {
            countMod += 1
            binding.modTextView.setText(getString(R.string.modifier) + " ${countMod}")
        }
        // d4 roll
        binding.d4ImageButton.setOnClickListener {
            // Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1, 5)
                }

                //   Log.i("STATUS_NUM", "RANDOM NUMBERS: ${randomNum}")
                val total = countMod + randomNum.sum()
                //  Log.i("STATUS_NUM", "TOTAL: ${total}")

                if (countMod > 0) {
                    header = "${countDice}d4+${countMod}"
                } else if (countMod < 0) {
                    header = "${countDice}d4${countMod}"
                } else if (countMod == 0) {
                    header = "${countDice}d4"
                }

                val builder = AlertDialog.Builder(
                    binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message = "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton(android.R.string.ok, null)
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.missing_die), Toast.LENGTH_LONG
                ).show()
            }
        }
        // d6 roll
        binding.d6ImageButton.setOnClickListener {
            //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1, 7)
                }

                //    Log.i("STATUS_NUM", "RANDOM NUMBERS: ${randomNum}")
                val total = countMod + randomNum.sum()
                //   Log.i("STATUS_NUM", "TOTAL: ${total}")

                var header = ""

                if (countMod > 0) {
                    header = "${countDice}d6+${countMod}"
                } else if (countMod < 0) {
                    header = "${countDice}d6${countMod}"
                } else if (countMod == 0) {
                    header = "${countDice}d6"
                }

                val builder = AlertDialog.Builder(
                    binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message = "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton(android.R.string.ok, null)
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.missing_die), Toast.LENGTH_LONG
                ).show()
            }
        }
        //d8 roll
        binding.d8ImageButton.setOnClickListener {
            //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1, 9)
                }

                //  Log.i("STATUS_NUM", "RANDOM NUMBERS: ${randomNum}")
                val total = countMod + randomNum.sum()
                //  Log.i("STATUS_NUM", "TOTAL: ${total}")

                if (countMod > 0) {
                    header = "${countDice}d8+${countMod}"
                } else if (countMod < 0) {
                    header = "${countDice}d8${countMod}"
                } else if (countMod == 0) {
                    header = "${countDice}d8"
                }

                val builder = AlertDialog.Builder(
                    binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message = "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton(android.R.string.ok, null)
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.missing_die), Toast.LENGTH_LONG
                ).show()
            }
        }
        // d10 roll
        binding.d10ImageButton.setOnClickListener {
            // Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1, 11)
                }

                // Log.i("STATUS_NUM", "RANDOM NUMBERS: ${randomNum}")
                val total = countMod + randomNum.sum()
                //  Log.i("STATUS_NUM", "TOTAL: ${total}")

                if (countMod > 0) {
                    header = "${countDice}d10+${countMod}"
                } else if (countMod < 0) {
                    header = "${countDice}d10${countMod}"
                } else if (countMod == 0) {
                    header = "${countDice}d10"
                }

                val builder = AlertDialog.Builder(
                    binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message = "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton(android.R.string.ok, null)
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.missing_die), Toast.LENGTH_LONG
                ).show()
            }
        }
        // d12 roll
        binding.d12ImageButton.setOnClickListener {
            //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1, 13)
                }

                //   Log.i("STATUS_NUM", "RANDOM NUMBERS: ${randomNum}")
                val total = countMod + randomNum.sum()
                //   Log.i("STATUS_NUM", "TOTAL: ${total}")

                if (countMod > 0) {
                    header = "${countDice}d12+${countMod}"
                } else if (countMod < 0) {
                    header = "${countDice}d12${countMod}"
                } else if (countMod == 0) {
                    header = "${countDice}d12"
                }

                val builder = AlertDialog.Builder(
                    binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message = "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton(android.R.string.ok, null)
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.missing_die), Toast.LENGTH_LONG
                ).show()
            }
        }
        // d20 roll
        binding.d20ImageButton.setOnClickListener {
            //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1, 21)
                }

                //  Log.i("STATUS_NUM", "RANDOM NUMBERS: ${randomNum}")
                val total = countMod + randomNum.sum()
                //  Log.i("STATUS_NUM", "TOTAL: ${total}")

                if (countMod > 0) {
                    header = "${countDice}d20+${countMod}"
                } else if (countMod < 0) {
                    header = "${countDice}d20${countMod}"
                } else if (countMod == 0) {
                    header = "${countDice}d20"
                }

                val builder = AlertDialog.Builder(
                    binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message = "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton(android.R.string.ok, null)
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.missing_die), Toast.LENGTH_LONG
                ).show()
            }
        }
        // d00 roll
        binding.d00ImageButton.setOnClickListener {
            //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1, 11) *10
                }

                //  Log.i("STATUS_NUM", "RANDOM NUMBERS: ${randomNum}")
                val total = countMod + randomNum.sum()
                //  Log.i("STATUS_NUM", "TOTAL: ${total}")

                if (countMod > 0) {
                    header = "${countDice}d100+${countMod}"
                } else if (countMod < 0) {
                    header = "${countDice}d100${countMod}"
                } else if (countMod == 0) {
                    header = "${countDice}d100"
                }

                val builder = AlertDialog.Builder(
                    binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message = "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton(android.R.string.ok, null)
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.missing_die), Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val preferences =
            getSharedPreferences(getString(R.string.preferences_storage_name),
                MODE_PRIVATE
            )

        val background = preferences.getString(getString(R.string.background_color_key),
            getString(R.string.background_color_dragon)
        )

        if (background.equals("dragon")) {
            binding.ConstraintLayout.setBackgroundResource(R.drawable.dragon)
        } else if (background.equals("antique")) {
            binding.ConstraintLayout.setBackgroundResource(R.drawable.antique)
        } else if (background.equals("forrest")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#6B8E23"))
        } else if (background.equals("gold")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#DAA520"))
        } else if (background.equals("lavender")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#E6E6FA"))
        } else if (background.equals("sandy")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#FFDAB9"))
        } else if (background.equals("silver")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#D3D3D3"))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.reset) {
            countDice = 1
            countMod = 0

            binding.diceNumTextView.setText(getString(R.string.number_of_dice) + " ${countDice}")
            binding.modTextView.setText(getString(R.string.modifier) + " ${countMod}")
            return true
        } else if (item.itemId == R.id.preferences) {
            val intent = Intent(this, preferences::class.java)
            startActivity(intent)
            return true
        } else if (item.itemId == R.id.about) {
            val intent = Intent(this, about::class.java)
            startActivity(intent)
            return true
        } else if(item.itemId == R.id.instructions) {
            val intent = Intent(this, instructions::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}


/*
Developer Notes (4/16/22):
* Need to add decorations or theme, i.e. maybe dicey or dungeony ???
* If time permitting, see about cleaning up the code, i.e. moving stuff to functions
* Others pending...

 */