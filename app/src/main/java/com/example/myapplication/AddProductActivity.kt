package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddProductActivity: AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_product)

        val zatwierdzButton = findViewById<Button>(R.id.zatwierdzButton)

        zatwierdzButton.setOnClickListener {
            val nazwaPotrawy = findViewById<EditText>(R.id.nazwaPotrawy)
            val nazwaAuthor = findViewById<EditText>(R.id.nazwaAuthor)
            val nazwaOcena = findViewById<EditText>(R.id.nazwaOcena)
            val nazwaData = findViewById<EditText>(R.id.nazwaData)

            val database = getSharedPreferences("database", Context.MODE_PRIVATE)
            var n: Int = 0
            for (i in generateSequence(0) { it }) {
                n++
                if (database.contains("savedNazwa$n")) {
                }
                else{
                    database.edit().apply {
                        putString("savedNazwa$n", nazwaPotrawy.text.toString())
                        putString("savedAuthor$n", nazwaAuthor.text.toString())
                        putString("savedOcena$n", nazwaOcena.text.toString())
                        putString("savedData$n", nazwaData.text.toString())
                    }.apply()
                    break
                }
            }
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}