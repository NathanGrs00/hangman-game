package com.nathan.hangman

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnStartGame = findViewById<Button>(R.id.btn_game)
        val btnOptions = findViewById<Button>(R.id.btn_options)
        val btnQuit = findViewById<Button>(R.id.btn_exit)
        val ivSettings = findViewById<ImageView>(R.id.iv_settings)

        btnStartGame.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnOptions.setOnClickListener {
            //TODO: Intent to options activity
            // val intent = Intent(this, OptionsActivity::class.java)
            // startActivity(intent)
        }

        btnQuit.setOnClickListener {
            finish()
        }

        ivSettings.setOnClickListener{
            //TODO: Intent to options activity
            // val intent = Intent(this, OptionsActivity::class.java)
            // startActivity(intent)
        }

    }
}