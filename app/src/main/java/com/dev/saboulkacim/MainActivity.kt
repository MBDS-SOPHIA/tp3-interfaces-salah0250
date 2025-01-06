package com.dev.saboulkacim

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val targetNumberInput: EditText = findViewById(R.id.target_number)
        val dice1Image: ImageView = findViewById(R.id.dice1_image)
        val dice2Image: ImageView = findViewById(R.id.dice2_image)

        targetNumberInput.addTextChangedListener { text ->
            val input = text.toString()

            if (input.isNotEmpty() && input.toIntOrNull() != null) {
                val targetNumber = input.toInt()
                rollDice(dice1Image, dice2Image, targetNumber)
            }
        }
    }

    private fun rollDice(dice1Image: ImageView, dice2Image: ImageView, targetNumber: Int) {
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        val roll1 = dice1.roll()
        val roll2 = dice2.roll()

        dice1Image.setImageResource(getDiceImage(roll1))
        dice2Image.setImageResource(getDiceImage(roll2))

        val sum = roll1 + roll2

        if (sum == targetNumber) {
            animateDice(dice1Image, dice2Image)
            Toast.makeText(this, getString(R.string.win_message), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, getString(R.string.lose_message), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDiceImage(roll: Int): Int {
        return when (roll) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.dice1
        }
    }

    private fun animateDice(dice1Image: ImageView, dice2Image: ImageView) {
        val anim1 = ObjectAnimator.ofFloat(dice1Image, "translationX", -50f, 50f).apply {
            duration = 500
            repeatCount = 3
            repeatMode = ObjectAnimator.REVERSE
        }
        val anim2 = ObjectAnimator.ofFloat(dice2Image, "translationX", -50f, 50f).apply {
            duration = 500
            repeatCount = 3
            repeatMode = ObjectAnimator.REVERSE
        }

        anim1.start()
        anim2.start()
    }
}
