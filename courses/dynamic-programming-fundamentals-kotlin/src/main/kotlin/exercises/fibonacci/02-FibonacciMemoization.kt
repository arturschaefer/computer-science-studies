package exercises.fibonacci

import exercises.nanoTimeToSecondsString
import kotlin.system.measureNanoTime

fun printFibonacciMemoizationResult(fibList: List<Int>){
    for (value in fibList){
        var result: Long
        val nanoTime = measureNanoTime{
            result = fibonacciMemoization(value.toLong(), hashMapOf())
        }
        println("fibonacciMemoization($value) -> $result with ${nanoTime.nanoTimeToSecondsString()} seconds")
    }
    println()
}

private fun fibonacciMemoization(n: Long, cache: HashMap<Long, Long>): Long{
    if (n == 1L || n == 0L) return 1

    cache[n]?.let {
        return@fibonacciMemoization it
    }

    val result  = fibonacciMemoization(n -1, cache) + fibonacciMemoization(n -2, cache)
    cache[n] = result
    return result
}