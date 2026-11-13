package com.example.actividadevaluable

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnAbrirUrl = findViewById<Button>(R.id.btnAbrirUrl)

        btnAbrirUrl.setOnClickListener {
            var url = etUrl.text.toString().trim()

            if (TextUtils.isEmpty(url) || !Patterns.WEB_URL.matcher(url).matches()) {
                Toast.makeText(this, "Introduzca una URL válida", Toast.LENGTH_SHORT).show()
            } else {
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "https://$url"
                }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }
}