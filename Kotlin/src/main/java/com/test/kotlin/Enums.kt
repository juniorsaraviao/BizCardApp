package com.test.kotlin

import java.io.IOException
import java.lang.Exception
import java.lang.NullPointerException

fun main() {
//    val input = Result.ERROR
//    getResult(input)

    Repository.startFetch()
    getResult(Repository.getCurrentState())
    Repository.finishedFetch()
    getResult(Repository.getCurrentState())
    Repository.error()
    getResult(Repository.getCurrentState())

    Repository.anotherCustomFailure()
    getResult(Repository.getCurrentState())
    Repository.customFailure()
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

    fun anotherCustomFailure() {
        loadState = Failure.AnotherCustomFailure(NullPointerException("something went wrong"))
    }

    fun customFailure() {
        loadState = Failure.CustomFailure(IOException("Custom Failure"))
    }
}

fun getResult(result: Result) {
    return when( result ){
        is Error -> println(result.exception.toString())
        is Success -> println(result.dataFetched ?: "Ensure you start the fetch function first")
        is Loading -> println("Loading...")
        is NotLoading -> println("Idle")
        is Failure.AnotherCustomFailure -> println(result.anotherCustomFailure.toString())
        is Failure.CustomFailure -> println(result.customFailure.toString())
    }
}

//enum class Result {
//    SUCCESS,
//    FAILURE,
//    ERROR,
//    IDLE,
//    LOADING
//}

// all the states created are exhaustive - not need 'else'
sealed class Result

data class Success(val dataFetched: String?) : Result()
data class Error(val exception: Exception) : Result()
object NotLoading: Result()
object Loading: Result()


sealed class Failure: Result() {
    data class CustomFailure( val customFailure: IOException ): Failure()
    data class AnotherCustomFailure( val anotherCustomFailure: NullPointerException ) : Failure()
}