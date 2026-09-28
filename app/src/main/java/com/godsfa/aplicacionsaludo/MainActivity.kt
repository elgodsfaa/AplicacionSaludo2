package com.godsfa.aplicacionsaludo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val etNombre = findViewById<EditText>(R.id.Nombre)
        val btnSaludar = findViewById<Button>(R.id.buttonSaludar)
        val btnLimpiar = findViewById<Button>(R.id.butttonLimpiar)
        val tvSaludo = findViewById<TextView>(R.id.Mensaje)

        // Acción del botón Saludar
        btnSaludar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            if (nombre.isNotEmpty()) {
                tvSaludo.text = "Hola, $nombre"
            } else {
                Toast.makeText(this, "Por favor, escribe un nombre", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción del botón Limpiar
        btnLimpiar.setOnClickListener {
            etNombre.text.clear()
            tvSaludo.text = ""
            etNombre.requestFocus()
        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}