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
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

        }
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(8)
        val droll = dice.roll()
        val drol2 = dice2.roll()
        val imageResult: ImageView = findViewById(R.id.imageView)
        val imageResource = when(droll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imageResult.setImageResource(imageResource)
        imageResult.contentDescription = droll.toString()


    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()

    }
}