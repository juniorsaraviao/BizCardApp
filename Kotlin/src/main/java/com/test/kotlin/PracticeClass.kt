package com.test.kotlin

import java.awt.Color

fun main(){
    val car = Car("Green")
    println(car.model)
    car.model = "Change"
    println(car.driver)

    // Truck

    val truck = Truck("Truck driver", "Magenta", "F16")
    truck.drive()
}

// make the class Car open to inherit from it
class Truck(driver: String, color: String, model: String) : Car(driver, color, model) {
    override fun drive() {
        println("Run truck....")
    }
}

open class Car(var driver: String, var color: String, var model: String) {

    init {
        println("Init Car")
        if (this.color == "Green") println("Yes, it's green") else println("$color is not Green")
    }

    constructor(color: String) : this ("Taxi driver", color, "Taxi"){
        println("Construct Car")
    }

    // make drive open if we can override this function
    open fun drive(){
        println("Init run...")
    }
}