package com.dev.saboulkacim

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val targetNumberInput: EditText = findViewById(R.id.target_number)
        val rollButton: Button = findViewById(R.id.roll_button)
        val dice1Result: TextView = findViewById(R.id.dice1_result)
        val dice2Result: TextView = findViewById(R.id.dice2_result)

        targetNumberInput.addTextChangedListener {
            val input = it.toString()
            rollButton.isEnabled = input.isNotEmpty() && input.toIntOrNull() != null
        }

        rollButton.setOnClickListener {
            val targetNumber = targetNumberInput.text.toString().toInt()

            val dice1 = Dice(6)
            val dice2 = Dice(6)

            val roll1 = dice1.roll()
            val roll2 = dice2.roll()

            dice1Result.text = roll1.toString()
            dice2Result.text = roll2.toString()

            val sum = roll1 + roll2

            if (sum == targetNumber) {
                Toast.makeText(this, getString(R.string.win_message), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, getString(R.string.lose_message), Toast.LENGTH_SHORT).show()
            }
        }
    }
}