package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddProductActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_product)

        val database = getSharedPreferences("database", Context.MODE_PRIVATE)
        database.edit().apply{
            val nazwaPotrawy = findViewById<EditText>(R.id.nazwaPotrawy)
            putString("savedNazwa", nazwaPotrawy.text.toString())
        }.apply()
    }
}