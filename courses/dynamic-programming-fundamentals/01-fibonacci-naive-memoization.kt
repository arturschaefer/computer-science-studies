import kotlin.system.*

fun main(){
    printFibonacciNaiveResult(listOf(20, 30, 40))
    printFibonacciMemoizationResult(listOf(50, 100))
}

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

fun fibonacciNaive(n: Int): Int {
    return when(n){
        0, 1 -> 1
        else -> fibonacciNaive(n -1) + fibonacciNaive(n -2)
    }
}

fun fibonacciMemoization(n: Long, cache: HashMap<Long, Long>): Long{
    if (n == 1L || n == 0L) return 1
    
    cache.get(n)?.let { 
        return@fibonacciMemoization it
    }

    val result  = fibonacciMemoization(n -1, cache) + fibonacciMemoization(n -2, cache)
    cache[n] = result
    return result
}

private const val NANOSECONDS_IN_SECONDS = 1_000_000_000f

private fun Long.nanoTimeToSecondsString() = String.format("%.8f", this / NANOSECONDS_IN_SECONDS)
