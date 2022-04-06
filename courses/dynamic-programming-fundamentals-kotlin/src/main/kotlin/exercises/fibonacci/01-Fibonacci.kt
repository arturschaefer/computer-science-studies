package exercises.fibonacci

fun main(){
    printFibonacciNaiveResult(listOf(20, 30, 40))
    printFibonacciMemoizationResult(listOf(50, 100, 1000))
    printFibonacciBottomUp(listOf(50, 1000))
}