package com.example.recyclerview5toa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityNuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener{
            val txtnombre = findViewById<TextView>(R.id.txtAddName).text.toString()
            val txtCuenta = findViewById<TextView>(R.id.txtAddCuenta).text.toString()
            val txtCorreo = findViewById<TextView>(R.id.txtAddCorreo).text.toString()
            val txtImagen = findViewById<TextView>(R.id.txtAddImagen).text.toString()

            val intento2 = Intent(this, MainActivity::class.java)
            intento2.putExtra("mensaje", "nuevo")
            intento2.putExtra("nombre","${txtnombre }")
            intento2.putExtra("cuenta","${txtCuenta}")
            intento2.putExtra("correo","${txtCorreo}")
            intento2.putExtra("imagen","${txtImagen}")
            startActivity(intento2)
            finish()
        }
    }
}