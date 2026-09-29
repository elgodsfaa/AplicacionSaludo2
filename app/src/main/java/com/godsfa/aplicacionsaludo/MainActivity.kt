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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val Nombre : EditText = findViewById(R.id.Nombre)
        val btnSaludar: Button = findViewById(R.id.btnSaludar)
        val Mensaje: TextView = findViewById(R.id.Mensaje)
        val btnLimpiar: Button = findViewById(R.id.btnLimpiar)


        btnSaludar.setOnClickListener {
            val name = Nombre.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(this, "Escribe tu nombre", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                Mensaje.text = "Hola, $name"
            }

        }
        btnLimpiar.setOnClickListener {
            Nombre.text.clear()
            Mensaje.text = ""
        }
    }
}






