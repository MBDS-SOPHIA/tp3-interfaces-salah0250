package com.dev.saboulkacim

import kotlin.random.Random

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}