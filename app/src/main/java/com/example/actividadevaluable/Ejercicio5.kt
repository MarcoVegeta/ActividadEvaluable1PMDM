package com.example.actividadevaluable

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio5 : AppCompatActivity() {
    private lateinit var tvPantalla: TextView
    private var num1 = 0.0
    private var operador = ""
    private var nuevoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        tvPantalla = findViewById(R.id.tvPantalla)

        val idsNumeros = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in idsNumeros) {
            findViewById<Button>(id).setOnClickListener { v ->
                val digito = (v as Button).text.toString()
                if (nuevoNumero) {
                    tvPantalla.text = digito
                    nuevoNumero = false
                } else {
                    tvPantalla.append(digito)
                }
            }
        }

        findViewById<Button>(R.id.btnPunto).setOnClickListener {
            val actual = tvPantalla.text.toString()
            if (nuevoNumero) {
                tvPantalla.text = "0."
                nuevoNumero = false
            } else if (!actual.contains(".")) {
                tvPantalla.append(".")
            }
        }

        findViewById<Button>(R.id.btnSum).setOnClickListener { prepararOperacion("+") }
        findViewById<Button>(R.id.btnRes).setOnClickListener { prepararOperacion("-") }
        findViewById<Button>(R.id.btnMul).setOnClickListener { prepararOperacion("*") }
        findViewById<Button>(R.id.btnDiv).setOnClickListener { prepararOperacion("/") }

        findViewById<Button>(R.id.btnIgual).setOnClickListener { calcular() }

        findViewById<Button>(R.id.btnC).setOnClickListener {
            tvPantalla.text = "0"
            num1 = 0.0
            operador = ""
            nuevoNumero = true
        }
    }

    private fun prepararOperacion(op: String) {
        num1 = tvPantalla.text.toString().toDouble()
        operador = op
        nuevoNumero = true
    }

    private fun calcular() {
        if (operador.isEmpty()) return
        val num2 = tvPantalla.text.toString().toDouble()
        var resultado = 0.0

        when (operador) {
            "+" -> resultado = num1 + num2
            "-" -> resultado = num1 - num2
            "*" -> resultado = num1 * num2
            "/" -> {
                if (num2 == 0.0) {
                    tvPantalla.text = "Error"
                    nuevoNumero = true
                    operador = ""
                    return
                }
                resultado = num1 / num2
            }
        }
        tvPantalla.text = resultado.toString()
        operador = ""
        nuevoNumero = true
    }
}