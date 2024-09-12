package com.example.recyclerview5toa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerPersonas)

        recyclerView.layoutManager= LinearLayoutManager(this)

        val data = ArrayList<Alumno>()

        for (i in 1 .. 2) {
            data.add(Alumno("Edgar Palomares", "20192025", "epalomares@ucol.mx", "https://www.shutterstock.com/image-vector/spiderman-suit-icon-logo-super-600w-2407844867.jpg"))
            data.add(Alumno("Julio Anguiano", "20197482", "janguiano@ucol.mx", "https://www.shutterstock.com/image-vector/spiderman-suit-icon-logo-super-600w-2407844867.jpg"))
            data.add(Alumno("Armando Escalera", "20178035", "aescalera@ucol.mx", "https://www.shutterstock.com/image-vector/spiderman-suit-icon-logo-super-600w-2407844867.jpg"))
            data.add(Alumno("Raul Herrera", "20183403", "jherrera10@ucol.mx", "https://www.shutterstock.com/image-vector/spiderman-suit-icon-logo-super-600w-2407844867.jpg"))
        }

        val adapter = AlumnoAdapter(this, data)
        recyclerView.adapter = adapter

        val parExtras = intent.extras
        val mensaje = parExtras?.getString("mensaje")
        val nombre = parExtras?.getString("nombre")
        val cuenta = parExtras?.getString("cuenta")
        val correo = parExtras?.getString("correo")
        val img = parExtras?.getString("imagen")

        if (mensaje == "nuevo alumno") {
            val insertIndex: Int = data.count()
            data.add(insertIndex, Alumno(nombre.toString(),
                cuenta.toString(),
                correo.toString(),
                img.toString()))
            adapter.notifyItemInserted(insertIndex)
        }

        btnAdd.setOnClickListener{
            val intento1 = Intent(this, MainActivityNuevo::class.java)
            startActivity(intento1)
            finish()
        }
    }
}