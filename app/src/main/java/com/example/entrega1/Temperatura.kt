package com.example.entrega1
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Temperatura : AppCompatActivity() {
    private var lastChangedField: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_temperatura)
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
        val celsius = findViewById<EditText>(R.id.celcius)
        val fahrenheit = findViewById<EditText>(R.id.farenheit)

        //Save changed field
        celsius.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                lastChangedField = "Celsius"
            }
        }

        fahrenheit.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                lastChangedField = "Fahrenheit"
            }
        }

        //Convert
        val convertButton = findViewById<Button>(R.id.convert)
        convertButton.setOnClickListener {
            when (lastChangedField) {
                "Celsius" -> {
                    val celsiusText = celsius.text.toString()
                    if (celsiusText.isNotEmpty()) {
                        val celsiusVal = celsiusText.toDouble()
                        val fahrenheitVal = (celsiusVal * 9 / 5) + 32
                        fahrenheit.setText(fahrenheitVal.toString())
                    } else {
                        Toast.makeText(this, "Celsius.", Toast.LENGTH_SHORT).show()
                    }
                }
                "Fahrenheit" -> {
                    val fahrenheitText = fahrenheit.text.toString()
                    if (fahrenheitText.isNotEmpty()) {
                        val fahrenheitVal = fahrenheitText.toDouble()
                        val celsiusVal = (fahrenheitVal - 32) * 5 / 9
                        celsius.setText(celsiusVal.toString())
                    } else {
                        Toast.makeText(this, "Fahrenheit.", Toast.LENGTH_SHORT).show()
                    }
                }
                else -> {
                    Toast.makeText(this, "Please enter a value in either field.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}