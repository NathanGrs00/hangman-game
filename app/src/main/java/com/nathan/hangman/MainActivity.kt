package com.nathan.hangman

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    fun buttonIfYouPressThisTheColorWillChange(view: View) {
        val btnQ: Button = findViewById(R.id.btn_game_keyboard_q)
        btnQ.setTag("Q")

        val keyboardButton : Button = view as Button

        btnQ.background = getDrawable(R.drawable.shape_keyboard_button_succes)
        println(view.id)

        when (view.text) {
            getString(R.string.keyboard_q) -> println("Dit is een w")
        }

        if (view.id == R.id.btn_game_keyboard_q) {
            println("Dit is de Q")
        } else if (view.id == R.id.btn_game_keyboard_a)
            println("Dit is de A")
    }
}