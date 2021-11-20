package com.test.kotlin

class MyClass {
}

fun main() {
    val name = "Kotlin"

    println("Hello $name")

    val a = 23
    val b = 12
    println(a.toDouble() / b.toDouble())

    var value = when (b){
        in 12..15 -> "good"
        16 -> "really good"
        else -> "bad"
    }

    println(value)

    for (i in 1 until 3){
        println(i)
    }

}