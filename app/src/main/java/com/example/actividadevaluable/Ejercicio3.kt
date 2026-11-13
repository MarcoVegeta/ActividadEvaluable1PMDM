package com.example.actividadevaluable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ejercicio3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        findViewById<Button>(R.id.btnPant1).setOnClickListener { startActivity(Intent(this, Ej3Pantalla1::class.java)) }
        findViewById<Button>(R.id.btnPant2).setOnClickListener { startActivity(Intent(this, Ej3Pantalla2::class.java)) }
        findViewById<Button>(R.id.btnPant3).setOnClickListener { startActivity(Intent(this, Ej3Pantalla3::class.java)) }
    }
}