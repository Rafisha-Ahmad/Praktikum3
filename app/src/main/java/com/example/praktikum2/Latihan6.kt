package com.example.praktikum2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class Latihan6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btproses = findViewById<Button>(R.id.btproses)
        val etnim = findViewById<EditText>(R.id.etnim)
        val etnama = findViewById<EditText>(R.id.etnama)
        val etkelas = findViewById<EditText>(R.id.etkelas)
        val ethasil = findViewById<EditText>(R.id.ethasil)

        btproses.setOnClickListener {
            val hasil: String = etnim.text.toString() + " " +
            etnama.text.toString() + " " +
            etkelas.text.toString()
            ethasil.append(hasil)
        }
    }
}