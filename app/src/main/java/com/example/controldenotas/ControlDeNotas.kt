package com.example.controldenotas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ControlDeNotas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_de_notas)

        val etNota1 = findViewById<EditText>(R.id.etNota1)
        val etNota2 = findViewById<EditText>(R.id.etNota2)
        val etNota3 = findViewById<EditText>(R.id.etNota3)
        val etNota4 = findViewById<EditText>(R.id.etNota4)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)

        btnCalcular.setOnClickListener {
            val nota1 = etNota1.text.toString().toDoubleOrNull()
            val nota2 = etNota2.text.toString().toDoubleOrNull()
            val nota3 = etNota3.text.toString().toDoubleOrNull()
            val nota4 = etNota4.text.toString().toDoubleOrNull()

            if (nota1 != null && nota2 != null && nota3 != null && nota4 != null) {
                if (validarNota(nota1) && validarNota(nota2) && validarNota(nota3) && validarNota(nota4)) {
                    val notaDefinitiva = (nota1 * 0.2) + (nota2 * 0.3) + (nota3 * 0.15) + (nota4 * 0.35)
                    val resultado = if (notaDefinitiva >= 3) {
                        "Aprobado con: $notaDefinitiva"
                    } else {
                        "Reprobado con: $notaDefinitiva"
                    }
                    tvResultado.text = "Resultado: $resultado"
                } else {
                    Toast.makeText(this, "Las notas deben estar entre 1 y 5", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Debe ingresar todas las notas", Toast.LENGTH_SHORT).show()
            }
        }

        // Limpiar los campos de entrada y el resultado
        btnLimpiar.setOnClickListener {
            etNota1.text.clear()
            etNota2.text.clear()
            etNota3.text.clear()
            etNota4.text.clear()
            tvResultado.text = "Resultado: "
        }
    }

    // Función para validar que la nota esté entre 0 y 5
    private fun validarNota(nota: Double): Boolean {
        return nota in 0.0..5.0
    }
}
