import kotlin.system.*

fun main(){
    printFibonacciNaiveResult(listOf(20, 30, 40))
    printFibonacciMemoizationResult(listOf(50, 100, 1000))
    printFibonacciBottomUp(listOf(50, 1000))
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

fun fibonacciBottomUp(n: Int): Long{
    var a = 1L
    var b = 1L
    var temp = 0L
    
    for (i in 2..n) {
        temp = b
        b = a + b
        a = temp
    }
    return b
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

private const val NANOSECONDS_IN_SECONDS = 1_000_000_000f

private fun Long.nanoTimeToSecondsString() = String.format("%.8f", this / NANOSECONDS_IN_SECONDS)
