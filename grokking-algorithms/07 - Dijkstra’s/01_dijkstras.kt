import java.util.Deque
import java.util.LinkedList
import kotlin.collections.last
import kotlin.math.cos

private const val START = "start"
private const val A = "A"
private const val B = "B"
private const val FIN = "FIN"
private const val NONE = "none"


fun main() {
    val graph = hashMapOf(
        START to hashMapOf<String, Int>(),
        A to hashMapOf<String, Int>(),
        B to hashMapOf<String, Int>(),
        FIN to hashMapOf<String, Int>(),
    )
    val costs = hashMapOf<String, Int>()
    val parents = hashMapOf<String, String>()
    val processed = hashSetOf<String>()

    graph[START]?.put(A, 6)
    graph[START]?.put(B, 2)

    graph[A]?.put(FIN, 1)

    graph[B]?.put(A, 3)
    graph[B]?.put(FIN, 5)

    costs[A] = 6
    costs[B] = 2
    costs[FIN] = Int.MAX_VALUE

    parents[A] = START
    parents[B] = START
    parents[NONE] = NONE

    var node = findLowestCostNode(costs, processed)
    var totalCost = costs[node] ?: 0

    while (node != NONE){
        val cost = costs[node] ?: 0
        val neighbors = graph[node]

        for (n in neighbors?.keys!!){
            val newCost = cost + (neighbors[n] ?: 0)
            costs[n] = newCost
            parents[n] = node
        }

        processed.add(node)
        node = findLowestCostNode(costs, processed)
        totalCost += costs[node] ?: 0
    }

    println(parents)
    println(costs)
    println(processed)
}

fun findLowestCostNode(costs: HashMap<String, Int>, processed: Set<String>): String {
    var lowestCost = Int.MAX_VALUE
    var lowestCostNode = NONE

    for (node in costs) {
        val cost = node.value
        if (cost < lowestCost && !processed.contains(node.key)) {
            lowestCost = cost
            lowestCostNode = node.key
        }
    }

    return lowestCostNode
}