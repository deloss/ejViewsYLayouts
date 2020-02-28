package com.example.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var intentosRestantes : Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUI()
    }

    private fun setUI() {
        val respuestaCorrecta = "android"

        enviar.setOnClickListener {
            if(palabra_ingresada.text.toString().toLowerCase() == respuestaCorrecta.toLowerCase()) {
                enviar.isEnabled = false
                palabra_ingresada.isEnabled = false
                mensaje.text = "La respuesta es correcta!"
            } else {
                intentosRestantes--
                palabra_ingresada.text.clear()
                if(intentosRestantes == 0) {
                    enviar.isEnabled = false
                    palabra_ingresada.isEnabled = false
                    mensaje.text = "Has perdido, no te quedan mas intentos"
                } else {
                    mensaje.text = "Respuesta incorrecta, te quedan $intentosRestantes intentos restantes"
                }
            }
        }

        reset.setOnClickListener {
            intentosRestantes = 3
            enviar.isEnabled = true
            palabra_ingresada.isEnabled = true
            palabra_ingresada.text.clear()
            mensaje.text = ""
        }
    }
}
