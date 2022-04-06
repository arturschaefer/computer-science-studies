package exercises.fibonacci

import exercises.nanoTimeToSecondsString
import kotlin.system.measureNanoTime

fun printFibonacciBottomUp(fibList: List<Int>){
    for (value in fibList){
        var result: Long
        val nanoTime = measureNanoTime{
            result = fibonacciBottomUp(value)
        }
        println("FibonacciBottomUp($value) -> $result with ${nanoTime.nanoTimeToSecondsString()} seconds")
    }
    println()
}

private fun fibonacciBottomUp(n: Int): Long{
    var a = 1L
    var b = 1L
    var temp: Long

    for (i in 2..n) {
        temp = b
        b += a
        a = temp
    }
    return b
}