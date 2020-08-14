package com.example.mytestingapp

class CuboidModel(private val length: Double, private val width: Double, private val height: Double) {

    fun getVolume(): Double = width * length * height

    fun getSurfaceArea(): Double {
        val wl = width * length
        val wh = width * height
        val lh = length * height
        return 2 * (wl + wh + lh)
    }

    fun getCircumference(): Double = 4 * (width + length + height)

}