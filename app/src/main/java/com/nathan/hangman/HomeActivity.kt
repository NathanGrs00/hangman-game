package com.nathan.hangman

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sharedPreferences = getSharedPreferences("GamePrefs", MODE_PRIVATE)
        sharedPreferences.getString("difficulty", "easy")

        val btnStartGame = findViewById<Button>(R.id.btn_game)
        val btnOptions = findViewById<Button>(R.id.btn_options)
        val btnQuit = findViewById<Button>(R.id.btn_exit)
        val ivSettings = findViewById<ImageView>(R.id.iv_settings)

        btnStartGame.setOnClickListener {
            val queue = Volley.newRequestQueue(this)
            val url = "https://random-word-api.herokuapp.com/word?length=8"

            val stringRequest = StringRequest(
                url, { response ->
                    val word = response.toString()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("WORD", word)
                    startActivity(intent)
                    finish()
                }, { error ->
                    error.printStackTrace()
                })

            queue.add(stringRequest)
        }

        btnOptions.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        btnQuit.setOnClickListener {
            finish()
        }

        ivSettings.setOnClickListener{
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

    }
}