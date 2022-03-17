package com.example.diceroller

import org.junit.Assert.*
import org.junit.Test

class MainActivityTest {
    @Test
    fun generates_number() {
        val dice = Dice(6)
        val rollResult = dice.roll()
        assertTrue("The value of rollresult was not between 1 and 6", rollResult in 1..6)
    }
}