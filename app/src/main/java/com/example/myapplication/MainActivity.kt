package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lastSavedProduct = findViewById<TextView>(R.id.lastSavedProduct)

        val menuPlus = findViewById<FloatingActionButton>(R.id.menuPlus)
        menuPlus.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }
        var n: Int = 0
        var savedName: String ="null"
        var savedAuthor: String ="null"
        var savedOcena: String = "null"
        var savedData: String = "null"
        //var products = listOf(Product("null"))
        val preferences = getSharedPreferences("database", MODE_PRIVATE)
        for(i in generateSequence(0) { it }) {
            n++
            if (preferences.contains("savedNazwa$n")) {
                savedName =
                    preferences.getString("savedNazwa$n", "Brak nazwy dania").toString()
                d("foodName$n", "$savedName")
                if(savedName == ""){
                    savedName = "Brak nazwy"
                }

                savedAuthor =
                    preferences.getString("savedAuthor$n", "Brak autora").toString()
                d("authorName$n", "$savedAuthor")
                if(savedAuthor == ""){
                    savedAuthor = "Brak autora"
                }

                savedOcena =
                    preferences.getString("savedOcena$n", "Brak oceny").toString()
                d("ocenaName$n", "$savedOcena")
                if(savedOcena == ""){
                    savedOcena = "Brak oceny"
                }
                else{ savedOcena = "$savedOcena/10" }

                savedData =
                    preferences.getString("savedData$n", "Brak daty").toString()
                d("dataName$n", "$savedData")
                if(savedData == ""){
                    savedData = "Brak daty"
                }

                val products = listOf((Product("$savedName","$savedAuthor","$savedOcena","$savedData")))
                products.forEach {
                    d("foodName$n", "Product is: $it")
                    lastSavedProduct.append("${it.name} - ${it.author} - ${it.ocena} - ${it.data}\n ------ \n")
                }
            }
            else{break}
            // lastSavedProduct.text = savedName
        }
       // products.forEach{
            //d("daniel", "Product is: $it")
       //     lastSavedProduct.append("${it.name} \n \n")
        //}
    }
}