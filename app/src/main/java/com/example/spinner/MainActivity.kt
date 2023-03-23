package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var observ: TextView
    lateinit var spleng: Spinner
    lateinit var txtcara: TextView
    lateinit var txttitulo: TextView
    var lenguajes = arrayOf("JAVA", "KOTLIN", "PHP", "SWIFT", "C#", "C++", "DART", "JS")
    var comentari = arrayOf("Java:programación orientada a objetos", "KOTLIN:Programacion de codigo abierto y tipado estatico","PHP:es un lenguaje de programación destinado a desarrollar aplicaciones para la web y crear páginas web","SWIFT:lenguaje de programación creado por Apple que permite diseñar apps para iOS","C#:es un lenguaje de programación multiparadigma desarrollado y estandarizado por la empresa Microsoft","C++:Permite la manipulacion de objetos","DART:es un lenguaje de programación de código abierto, desarrollado por Google","JS:un lenguaje de secuencias de comandos que te permite crear contenido de actualización dinámica, controlar multimedia, animar imágenes y prácticamente todo lo demás")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //inicializar
        txttitulo = findViewById(R.id.tituloVentana)
        txtcara = findViewById(R.id.txtCaract)
        spleng = findViewById(R.id.sp_lenguajes)
        observ = findViewById(R.id.tituloVentana)

        //crea cuadritos por posiciones
        //se crea adaptador
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,lenguajes)

        //como se comportara
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spleng.adapter = adaptador
        spleng.onItemSelectedListener = this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, posicion: Int, p3: Long) {
        val selectlenguaje = lenguajes[posicion]
        val selectcaracteristicas = comentari[posicion]
        txttitulo.text = selectlenguaje
        val valorSeleccionado = lenguajes[posicion]
        Toast.makeText(this,"Selecciono $valorSeleccionado",Toast.LENGTH_LONG).show()
        txtcara.text = selectcaracteristicas

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        txttitulo.text = ""
        txtcara.text = ""
        observ.text = ""

    }
}