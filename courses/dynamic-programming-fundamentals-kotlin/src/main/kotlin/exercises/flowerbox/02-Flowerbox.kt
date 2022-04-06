package exercises.flowerbox

fun main() {
    println(flowerBox(listOf(3, 10, 3, 1, 2))) //R -> 12
    println(flowerBox(listOf(9, 10, 9))) //R -> 18
}

fun flowerBox(nutrientValues: List<Int>): Long {
    var a = 0L
    var b = 0L
    var temp: Long

    for (value in nutrientValues) {
        temp = b
        b = maxOf(a + value, b)
        a = temp
    }
    return b
}