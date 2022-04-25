package com.example.simplerpgdiceroller

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.location.GnssAntennaInfo
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioGroup
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
            binding.diceNumTextView.setTextColor(Color.BLACK)
            binding.modTextView.setTextColor(Color.BLACK)
            binding.diceNumTextView.setTypeface(Typeface.DEFAULT_BOLD)
            binding.modTextView.setTypeface(Typeface.DEFAULT_BOLD)
        } else if (background.equals("antique")) {
            binding.ConstraintLayout.setBackgroundResource(R.drawable.antique)
            binding.diceNumTextView.setTextColor(Color.RED)
            binding.modTextView.setTextColor(Color.RED)
            binding.diceNumTextView.setTypeface(Typeface.DEFAULT_BOLD)
            binding.modTextView.setTypeface(Typeface.DEFAULT_BOLD)
        } else if (background.equals("forrest")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#6B8E23"))
            binding.diceNumTextView.setTextColor(Color.YELLOW)
            binding.modTextView.setTextColor(Color.YELLOW)
            binding.diceNumTextView.setTypeface(Typeface.DEFAULT_BOLD)
            binding.modTextView.setTypeface(Typeface.DEFAULT_BOLD)
        } else if (background.equals("gold")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#DAA520"))
            binding.diceNumTextView.setTextColor(Color.parseColor("#008000"))
            binding.modTextView.setTextColor(Color.parseColor("#008000"))
            binding.diceNumTextView.setTypeface(Typeface.DEFAULT_BOLD)
            binding.modTextView.setTypeface(Typeface.DEFAULT_BOLD)
        } else if (background.equals("lavender")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#E6E6FA"))
            binding.diceNumTextView.setTextColor(Color.MAGENTA)
            binding.modTextView.setTextColor(Color.MAGENTA)
            binding.diceNumTextView.setTypeface(Typeface.DEFAULT_BOLD)
            binding.modTextView.setTypeface(Typeface.DEFAULT_BOLD)
        } else if (background.equals("sandy")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#FFDAB9"))
            binding.diceNumTextView.setTextColor(Color.BLUE)
            binding.modTextView.setTextColor(Color.BLUE)
            binding.diceNumTextView.setTypeface(Typeface.DEFAULT_BOLD)
            binding.modTextView.setTypeface(Typeface.DEFAULT_BOLD)
        } else if (background.equals("silver")) {
            binding.ConstraintLayout.setBackgroundColor(Color.parseColor("#D3D3D3"))
            binding.diceNumTextView.setTextColor(Color.parseColor("#4B0082"))
            binding.modTextView.setTextColor(Color.parseColor("#4B0082"))
            binding.diceNumTextView.setTypeface(Typeface.DEFAULT_BOLD)
            binding.modTextView.setTypeface(Typeface.DEFAULT_BOLD)
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
        } else if(item.itemId == R.id.jail) {
            val title = "<span style='color:#FF4500;'><big><big>GO TO JAIL!</big></big></span>"
            val message = "<b><big>Are your dice behaving badly???</big></b><br><br>" +
                    "<span style='color:#008000;'><big><b>You keep getting bad rolls???</b></big></span><br><br>" +
                    "<b><span style='color:#008B8B;'><big><big>Don't Fret!</big></big></b></span><br><br>" +
                    "<b><big><big><big>Just put them in <span style='color:red;'>Dice Jail </span>for a bit!!!</big></big></big></b>"
            val builder = AlertDialog.Builder(binding.root.context,
            R.style.Theme_Dialog_Alert
            )

            val text = "<b><big><span style='color:red;'>No worries, maybe next time!</b></big></span>"

            val listener = DialogInterface.OnClickListener { dialog, which ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    val intent = Intent(this, dice_jail::class.java)
                    startActivity(intent)
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    Toast.makeText(
                        applicationContext, (Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)), Toast.LENGTH_LONG
                    ).show()
                }
            }

            builder
                    .setTitle(Html.fromHtml(title, Html.FROM_HTML_MODE_LEGACY))
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .setPositiveButton("Yes!!", listener)
                    .setNegativeButton("I Changed my mind", listener)
                    .show()
            }
        return super.onOptionsItemSelected(item)
    }
 }
