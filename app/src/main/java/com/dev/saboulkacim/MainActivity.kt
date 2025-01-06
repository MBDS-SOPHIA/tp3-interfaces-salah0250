package com.dev.saboulkacim

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Références aux boutons et TextViews
        val rollButton: Button = findViewById(R.id.roll_button)
        val dice1Result: TextView = findViewById(R.id.dice1_result)
        val dice2Result: TextView = findViewById(R.id.dice2_result)

        // Écouteur pour le bouton
        rollButton.setOnClickListener {
            // Lance les deux dés
            val dice1 = Dice(6)
            val dice2 = Dice(6)

            val roll1 = dice1.roll()
            val roll2 = dice2.roll()

            // Affiche les résultats dans les TextViews
            dice1Result.text = roll1.toString()
            dice2Result.text = roll2.toString()

            // Vérifie si l'utilisateur gagne
            if (roll1 == roll2) {
                Toast.makeText(this, "Félicitations ! Vous avez gagné !", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Essayez encore !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}