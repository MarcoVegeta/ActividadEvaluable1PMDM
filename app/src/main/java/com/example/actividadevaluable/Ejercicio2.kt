package com.example.actividadevaluable

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        val btnRetraso = findViewById<Button>(R.id.btnRetraso)

        btnRetraso.setOnClickListener {
            Toast.makeText(this, "Navegando en 10 segundos...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Ejercicio2Destino::class.java)
            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    pendingIntent.send()
                } catch (e: PendingIntent.CanceledException) {
                    e.printStackTrace()
                }
            }, 10000)
        }
    }
}