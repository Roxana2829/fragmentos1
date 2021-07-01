package com.example.fragmentos1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fragmentos1.fragmentos.primeFragment
import com.example.fragmentos1.fragmentos.segundoFragment

class MainActivity : AppCompatActivity() {

    lateinit var btnffragmento1:Button
    lateinit var btnffragmento2:Button
    lateinit var btnNavegador:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnffragmento1 = findViewById(R.id.btnf1)
        btnffragmento2 = findViewById(R.id.btnf2)
        btnNavegador = findViewById(R.id.btnNavegador)

        btnffragmento1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, primeFragment.newInstance("ndo", "dsf"))
                    .commitNow()
        }

        btnffragmento2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, segundoFragment.newInstance("ndo","dsf"))
                    .commitNow()
        }

        btnNavegador.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor,NavegadorFragment.newInstance("https://google.com"))
                    .commitNow()
        }
        //argumentos para la funcion
        sumaNumeros(numero1:1, numero2:2)
    }

    //
    fun sumaNumeros(numero1:Int, numero2: Int){

    }
}