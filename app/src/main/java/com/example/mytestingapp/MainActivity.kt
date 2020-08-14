package com.example.mytestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var w: EditText
    private lateinit var h: EditText
    private lateinit var l: EditText
    private lateinit var result: TextView
    private lateinit var btnCalculateVolume: Button
    private lateinit var btnCalculateSurfaceArea: Button
    private lateinit var btnCalculateCircumference: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        w = findViewById(R.id.width)
        l = findViewById(R.id.length)
        h = findViewById(R.id.height)
        result = findViewById(R.id.result)
        btnCalculateCircumference = findViewById(R.id.circumference)
        btnCalculateSurfaceArea = findViewById(R.id.surface)
        btnCalculateVolume = findViewById(R.id.volume)
        btnSave = findViewById(R.id.save)

        btnSave.setOnClickListener(this)
        btnCalculateSurfaceArea.setOnClickListener(this)
        btnCalculateCircumference.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)

    }

    override fun onClick(p0: View) {
        val length = l.text.toString().trim()
        val width = w.text.toString().trim()
        val height = h.text.toString().trim()

        when {
            length.isEmpty() -> l.error = "This field cannot be empty"
            width.isEmpty() -> w.error = "This field cannot be empty"
            height.isEmpty() -> h.error = "This field cannot be empty"
            else -> {
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()

                when (p0.id) {
                    R.id.save -> {
                        mainViewModel = MainViewModel(CuboidModel(l, w, h))
                        visible()
                    }
                    R.id.volume -> {
                        result.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                    R.id.surface -> {
                        result.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.circumference -> {
                        result.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateCircumference.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun gone() {
        btnCalculateVolume.visibility = View.GONE
        btnCalculateCircumference.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }

}