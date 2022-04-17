package com.example.simplerpgdiceroller

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.simplerpgdiceroller.databinding.ActivityMainBinding
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
                    Random.nextInt(1,5)
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

                val builder = AlertDialog.Builder(binding.root.context,
                    R.style.Theme_Dialog_Alert
                    )
                val message =  "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(applicationContext,
                    getString(R.string.missing_die)
                    , Toast.LENGTH_LONG).show()
            }
        }
        // d6 roll
        binding.d6ImageButton.setOnClickListener {
          //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1,7)
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

                val builder = AlertDialog.Builder(binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message =  "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(applicationContext,
                    getString(R.string.missing_die)
                    , Toast.LENGTH_LONG).show()
            }
        }
        //d8 roll
        binding.d8ImageButton.setOnClickListener {
          //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1,9)
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

                val builder = AlertDialog.Builder(binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message =  "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(applicationContext,
                    getString(R.string.missing_die)
                    , Toast.LENGTH_LONG).show()
            }
        }
        // d10 roll
        binding.d10ImageButton.setOnClickListener {
           // Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1,11)
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

                val builder = AlertDialog.Builder(binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message =  "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(applicationContext,
                    getString(R.string.missing_die)
                    , Toast.LENGTH_LONG).show()
            }
        }
        // d12 roll
        binding.d12ImageButton.setOnClickListener {
          //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1,13)
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

                val builder = AlertDialog.Builder(binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message =  "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(applicationContext,
                    getString(R.string.missing_die)
                    , Toast.LENGTH_LONG).show()
            }
        }
        // d20 roll
        binding.d20ImageButton.setOnClickListener {
          //  Log.i("STATUS_NUM", "${countDice}")
            if (countDice !== 0) {
                val randomNum = List(countDice) {
                    Random.nextInt(1,21)
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

                val builder = AlertDialog.Builder(binding.root.context,
                    R.style.Theme_Dialog_Alert
                )
                val message =  "<b><big>${header}</big>" +
                        "</b><br><b><big><big><big><big><h1><span style='color:red;'>" +
                        "${total}</big></big></big></big></h1></span> Rolled: ${randomNum}</b>"

                builder
                    .setMessage(Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY))
                    .show()

            } else if (countDice < 1) {
                Toast.makeText(applicationContext,
                    getString(R.string.missing_die)
                    , Toast.LENGTH_LONG).show()
            }
        }
        // d00 roll

    }
}

/*
Developer Notes (4/16/22):
* Need to add the code for d00, either 1d00 random # 1..100 or 2d10 random # 1..10
* Need to fix the imageButton, i.e. image not scaling correctly
* Need to add decorations or theme, i.e. maybe dicey or dungeony ???
* Need to create App Icon
* Possibly add basic instructions, i.e. tap to roll, etc.
* Possibly add a menu for SharedPreferences, i.e. change background color, etc
* Possibly add a reset button, i.e. to clear the selected numbers
* Possibly add an About app
* If time permitting, see about cleaning up the code, i.e. moving stuff to functions
* Others pending...

 */