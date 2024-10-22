package com.example.entrega1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.ImageButton
import android.graphics.Color
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PiedraPapelTijera : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_piedra_papel_tijera)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Return to previous page
        val button = findViewById<Button>(R.id.back)
        button.setOnClickListener{
            val intent = Intent(this, activity_one::class.java)
            startActivity(intent)
        }

        //Variables
        val jugador = findViewById<TextView>(R.id.jugador)
        val computadora = findViewById<TextView>(R.id.computadora)

        var computadoraScore = 0
        var jugadorScore = 0

        val buttonPiedra = findViewById<ImageButton>(R.id.piedra)
        val buttonPapel = findViewById<ImageButton>(R.id.papel)
        val buttonTijeras = findViewById<ImageButton>(R.id.tijeras)

        //Game
        buttonPiedra.setOnClickListener{

            //Change color
            buttonPiedra.setColorFilter(Color.argb(128, 128, 0, 128))

            //Opciones
            val opciones = listOf("piedra", "papel", "tijeras")
            val randomChoice = opciones.random()
            when (randomChoice) {
                "piedra" -> {
                    computadoraScore += 1
                    jugadorScore += 1
                }
                "papel" -> {
                    computadoraScore += 1

                    //Change color
                    buttonPapel.setColorFilter(Color.argb(128, 128, 0, 128))
                }
                "tijeras" -> {
                    jugadorScore += 1

                    //Change color
                    buttonTijeras.setColorFilter(Color.argb(128, 128, 0, 128))
                }
            }

            //Reset colors
            Handler().postDelayed({
                buttonPiedra.clearColorFilter()
                buttonPapel.clearColorFilter()
                buttonTijeras.clearColorFilter()
            }, 1000)

            jugador.text = "Jugador: $jugadorScore"
            computadora.text = "Computadora: $computadoraScore"
        }


        buttonPapel.setOnClickListener{
            //Change color
            buttonPapel.setColorFilter(Color.argb(128, 128, 0, 128))

            val opciones = listOf("piedra", "papel", "tijeras")
            val randomChoice = opciones.random()
            when (randomChoice) {
                "papel" -> {
                    computadoraScore += 1
                    jugadorScore += 1
                }
                "tijeras" -> {
                    computadoraScore += 1
                    //Change color
                    buttonTijeras.setColorFilter(Color.argb(128, 128, 0, 128))
                }
                "piedra" -> {
                    jugadorScore += 1
                    //Change color
                    buttonPiedra.setColorFilter(Color.argb(128, 128, 0, 128))
                }
            }
            //Reset colors
            Handler().postDelayed({
                buttonPiedra.clearColorFilter()
                buttonPapel.clearColorFilter()
                buttonTijeras.clearColorFilter()
            }, 1000)

            jugador.text = "Jugador: $jugadorScore"
            computadora.text = "Computadora: $computadoraScore"
        }


        buttonTijeras.setOnClickListener{
            //Change color
            buttonTijeras.setColorFilter(Color.argb(128, 128, 0, 128))

            val opciones = listOf("piedra", "papel", "tijeras")
            val randomChoice = opciones.random()
            when (randomChoice) {
                "tijeras" -> {
                    computadoraScore += 1
                    jugadorScore += 1
                }
                "piedra" -> {
                    computadoraScore += 1
                    //Change color
                    buttonPiedra.setColorFilter(Color.argb(128, 128, 0, 128))
                }
                "papel" -> {
                    jugadorScore += 1
                    //Change color
                    buttonPapel.setColorFilter(Color.argb(128, 128, 0, 128))
                }
            }

            //Reset colors
            Handler().postDelayed({
                buttonPiedra.clearColorFilter()
                buttonPapel.clearColorFilter()
                buttonTijeras.clearColorFilter()
            }, 1000)

            jugador.text = "Jugador: $jugadorScore"
            computadora.text = "Computadora: $computadoraScore"
        }
    }
}