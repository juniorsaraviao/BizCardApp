package com.test.kotlin

import java.awt.Color

fun main(){
    val car = Car("Green")
    println(car.model)
    car.model = "Change"
    println(car.driver)
}

class Car(var driver: String, var color: String, var model: String) {

    init {
        println("Init Car")
        if (this.color == "Green") println("Yes, it's green") else println("$color is not Green")
    }

    constructor(color: String) : this ("Taxi driver", color, "Taxi"){
        println("Construct Car")
    }
}