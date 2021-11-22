package com.test.kotlin

import java.lang.Exception

fun main() {
//    val input = Result.ERROR
//    getResult(input)

    Repository.startFetch()
    getResult(Repository.getCurrentState())
    Repository.finishedFetch()
    getResult(Repository.getCurrentState())
    Repository.error()
    getResult(Repository.getCurrentState())
}

object Repository {
    private var loadState: Result = NotLoading
    private var dataFetched: String? = null

    fun startFetch() {
        loadState = Loading
        dataFetched = "data"
    }

    fun finishedFetch() {
        loadState = Success(dataFetched)
        dataFetched = null
    }

    fun error() {
        loadState = Error(exception = Exception("Exception"))
    }

    fun getCurrentState() : Result {
        return loadState
    }

}

fun getResult(result: Result) {
    return when( result ){
        is Error -> println(result.exception.toString())
        is Success -> println(result.dataFetched ?: "Ensure you start the fetch function first")
        is Loading -> println("Loading...")
        is NotLoading -> println("Idle")
        else -> println("N/A")
    }
}

//enum class Result {
//    SUCCESS,
//    FAILURE,
//    ERROR,
//    IDLE,
//    LOADING
//}

abstract class Result

data class Success(val dataFetched: String?) : Result()
data class Error(val exception: Exception) : Result()
object NotLoading: Result()
object Loading: Result()