package com.example.praktikum2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup

class Tugas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tugas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lampu = findViewById<ImageView>(R.id.lampuoff)
        val btLampu = findViewById<Button>(R.id.btLampu)
        val radiogroup = findViewById<RadioGroup>(R.id.rglampu)
        val rbPutih = findViewById<RadioButton>(R.id.rb_Putih)
        val rbKuning = findViewById<RadioButton>(R.id.rb_Kuning)
        val rbBiru = findViewById<RadioButton>(R.id.rb_Biru)

        var isLampOn = false

        fun setRadioEnabled(status: Boolean) {
            rbPutih.isEnabled = status
            rbKuning.isEnabled = status
            rbBiru.isEnabled = status
        }

        setRadioEnabled(false)

        btLampu.setOnClickListener {
            if (!isLampOn) {
                isLampOn = true
                btLampu.text = "TURN OFF"
                lampu.setImageResource(R.drawable.ic_lamp_light_on_white)
                setRadioEnabled(true)
                rbPutih.isChecked = true
            } else {
                isLampOn = false
                btLampu.text = "TURN ON"
                lampu.setImageResource(R.drawable.ic_lamp_light_off)
                setRadioEnabled(false)
                radiogroup.clearCheck()
            }
        }

        radiogroup.setOnCheckedChangeListener {_, checkedId ->
            if (!isLampOn) return@setOnCheckedChangeListener

            when (checkedId) {
                R.id.rb_Putih -> lampu.setImageResource(R.drawable.ic_lamp_light_on_white)
                R.id.rb_Kuning -> lampu.setImageResource(R.drawable.ic_lamp_light_on_yellow)
                R.id.rb_Biru -> lampu.setImageResource(R.drawable.ic_lamp_light_on_blue)
            }
        }
    }
}