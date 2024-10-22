package com.example.entrega1

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.Button)

        button.setOnClickListener {
            val usuario = findViewById<EditText>(R.id.usuario).text.toString()
            val contraseña = findViewById<EditText>(R.id.contraseña).text.toString()

            if (usuario == "Usuario" && contraseña  == "Contrasea") {
                val intent = Intent(this, activity_one::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Error.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}