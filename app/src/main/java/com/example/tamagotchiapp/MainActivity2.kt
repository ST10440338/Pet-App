package com.example.tamagotchiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    private var tvHunger: EditText? = null
    private var tvHappy: EditText? = null
    private var tvHealth: EditText? = null
    private var hungerCount = 0
    private var happyCount = 0
    private var healthCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvHunger = findViewById(R.id.tvHunger)
        tvHappy = findViewById(R.id.tvHappy)
        tvHealth = findViewById(R.id.tvHealth)

        findViewById<Button>(R.id.btnFeed).setOnClickListener {
            incrementCountAndSetText(tvHunger)
            updateImageView(R.drawable.whatsapp_image_2024_05_06_at_16_26_04)
        }

        findViewById<Button>(R.id.btnPlay).setOnClickListener {
            incrementCountAndSetText(tvHappy)
            updateImageView(R.drawable.whatsapp_image_2024_05_06_at_16_26_04__1_)
        }

        findViewById<Button>(R.id.btnShower).setOnClickListener {
            incrementCountAndSetText(tvHealth)
            updateImageView(R.drawable.jamie_street_ikv10lhzuas_unsplash)
        }

        findViewById<Button>(R.id.backButton)?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun incrementCountAndSetText(editText: EditText?) {
        editText?.let { editText ->
            val currentCount = when (editText) {
                tvHunger -> hungerCount
                tvHappy -> happyCount
                tvHealth -> healthCount
                else -> 0
            }

            if (currentCount < 10) {
                val newCount = currentCount + 1
                editText.setText(newCount.toString())
                when (editText) {
                    tvHunger -> hungerCount = newCount
                    tvHappy -> happyCount = newCount
                    tvHealth -> healthCount = newCount
                }
            }
        }
    }

    private fun updateImageView(imageResource: Int) {
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(imageResource)


    }
}



