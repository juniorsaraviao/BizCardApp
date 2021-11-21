package com.test.kotlin

fun main() {
    // Strings
    val list    = listOf("Rafael", "Gina", "George", "James")
    val finder = Finder(list)

    finder.findItem("Gina") {
        println("Found: $it")
    }

    // Integers
    val listNum = listOf(1, 10, 25, 15, null)
    val finderNum = Finder(listNum)

    finderNum.findItem(540) {
        println("Found Number: $it")
    }
}

class Finder<T>( private val list: List<T?> ) {
    fun findItem(element: T, foundItem: (element: T?) -> Unit ) {
        val itemFoundList = list.filter { it == element }

        if ( itemFoundList.isNullOrEmpty() ) foundItem(null) else foundItem(itemFoundList.first())
    }
}