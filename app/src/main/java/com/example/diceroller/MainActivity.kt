package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the botton in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {rollDice()
            //val toast = Toast.makeText(this, "Dice Rooled", Toast.LENGTH_SHORT)
            //toast.show()
        }
        rollDice()
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Not with pictures
        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = dice.roll().toString()

        // With pictures
        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableReseource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
            // Update the ImageView with the correct drawableke resource ID
            diceImage.setImageResource(drawableReseource)

            diceImage.contentDescription = diceRoll.toString()


    }
}

class Dice(private val numSides: Int) {
    // Do a random dice roll and return the result
    fun roll(): Int{
        return (1..numSides).random()
    }
}