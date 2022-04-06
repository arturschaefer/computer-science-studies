package exercises.fibonacci

import exercises.nanoTimeToSecondsString
import kotlin.system.*

fun printFibonacciNaiveResult(fibList: List<Int>){
    for (value in fibList){
        var result: Int
        val nanoTime = measureNanoTime{
            result = fibonacciNaive(value)
        }
        println("FibonacciNaive($value) -> $result with ${nanoTime.nanoTimeToSecondsString()} seconds")
    }
    println()
}

private fun fibonacciNaive(n: Int): Int {
    return when(n){
        0, 1 -> 1
        else -> fibonacciNaive(n -1) + fibonacciNaive(n -2)
    }
}
