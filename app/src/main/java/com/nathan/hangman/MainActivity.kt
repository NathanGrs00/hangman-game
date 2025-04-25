package com.nathan.hangman

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var word : String = "NACHTBUS"
    var letters = word.toCharArray()
    val textViewIds = listOf(
        R.id.tvPosition1,
        R.id.tvPosition2,
        R.id.tvPosition3,
        R.id.tvPosition4,
        R.id.tvPosition5,
        R.id.tvPosition6,
        R.id.tvPosition7,
        R.id.tvPosition8
    )
    var imageFailCounter = 0
    val images = listOf(
        R.drawable.stage_01,
        R.drawable.stage_02,
        R.drawable.stage_03,
        R.drawable.stage_04,
        R.drawable.stage_05,
        R.drawable.stage_06,
        R.drawable.stage_07,
        R.drawable.stage_08,
        R.drawable.stage_end,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textViewIds.forEachIndexed { index, id ->
            findViewById<TextView>(id).text = letters[index].toString()
            findViewById<TextView>(id).setTextColor(Color.TRANSPARENT)
        }
    }

    fun buttonIfYouPressThisTheColorWillChange(view: View) {
        view as Button

        if (word.contains(view.text)) {
            view.background = getDrawable(R.drawable.shape_keyboard_button_succes)

            for(i in 0..letters.size - 1) {
                if (letters[i].toString() == view.text) {
                    findViewById<TextView>(textViewIds[i]).setTextColor(Color.WHITE)
                }
            }

        } else {
            view.background = getDrawable(R.drawable.shape_keyboard_button_fail)
            var image = findViewById<ImageView>(R.id.iv_hangman)

            if (imageFailCounter != 9) {
                image.setImageDrawable(getDrawable(images[1 + imageFailCounter]))
                imageFailCounter++
            } else {
                image.setImageDrawable(getDrawable(images[8]))
            }
        }
        view.isClickable = false
    }
}