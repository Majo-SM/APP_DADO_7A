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
        rollButton.setOnClickListener { rollDice() }
    }
private fun rollDice() {
    // Create de nuevo objaeto
    val dice = Dice(6)
    val diceRoll = dice.roll()
    // Incotrar la imagen por id
    val diceImage: ImageView = findViewById(R.id.imageView)
    // Determina cada imagen del dado relacionado con la Id asignada
    val drawableResource = when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    // Indica actualización de imagen del dado
    diceImage.setImageResource(drawableResource)
    // Actualización de contenido de descripción
    diceImage.contentDescription = diceRoll.toString()
  }
}
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

