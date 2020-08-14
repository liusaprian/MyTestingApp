package com.example.mytestingapp

class MainViewModel(private val cube: CuboidModel) {
    fun getCircumference(): Double = cube.getCircumference()
    fun getSurfaceArea(): Double = cube.getSurfaceArea()
    fun getVolume(): Double = cube.getVolume()
}