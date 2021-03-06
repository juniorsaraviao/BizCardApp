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

    calculate(10, 20, 5)
    println("Cat age is ${calculateCatAge(5)}")
    println(sum(10, 12))
    printName("Android - Kotlin")
    enhancedMessage("Hello, Peter"){
        println("message: $it")
        sum(20, 26)
    }

    // List
    val listOfName = listOf("James", "Paul", "Rafael", "Gina").toMutableList()
    listOfName.add("Luis")
    listOfName.forEach { println(it) }

    // Map key - value
    val map = mapOf("Up" to 1, "Down" to 2, "Left" to 3, "Right" to 4)
    println(map["Left"])
}

fun calculate(first: Int, last: Int, multipleOf: Int, message: String = "is multiple of") {
    for(i in first..last){
        if( i % multipleOf == 0 ){
            println("$i $message $multipleOf")
        }
    }
}

//fun calculateCatAge(age: Int): Int {
//    return age * 7
//}

val calculateCatAge: (Int) -> Int = {catAge -> catAge * 7}

//fun sum(a: Int, b: Int): Int{
//    return a + b
//}

val sum: (Int, Int) -> Int = { a, b -> a + b  }

// Lambdas with void
val printName: (String) -> Unit = { println(it) }

fun enhancedMessage( message: String, funAsParameter: (String) -> Int ) {
    println("$message ${funAsParameter("Hey")}")
}