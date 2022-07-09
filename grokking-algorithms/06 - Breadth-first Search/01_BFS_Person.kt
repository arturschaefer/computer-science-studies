import java.util.Deque
import java.util.LinkedList
import kotlin.collections.last

fun main() {

    val valuesList = listOf(
        Person("you") to listOf(Person("alice"), Person("bob"), Person("claire")),
        Person("bob") to listOf(Person("anuj"), Person("peggy")),
        Person("alice") to listOf(Person("peggy")),
        Person("claire") to listOf(Person("thom", true), Person("jonny")),
        Person("anuj") to emptyList(),
        Person("peggy") to emptyList(),
        Person("thom", true) to emptyList(),
        Person("jonny") to emptyList(),
    )

    val graph = Graph<Person>(valuesList)
    val result = graph.breadthFirstSearch(Person("you"), Person::isMangoSeller)

    result?.let { 
        println("${it.last().name} is a Mango Seller")
        println("Searched graph -> ${result.toString()}") 
    } ?: println("There is no Mango seller")
}

data class Person(val name: String, val isMangoSeller: Boolean = false) {
    override fun equals(other: Any?): Boolean = if (other is Person) other.name == name else false
}

class Graph<V>(val values: List<Pair<V, List<V>>>){

    // O(V+E) (V for number of vertices, E for number of edges)
    fun breadthFirstSearch(key: V, searchFunction: (V) -> Boolean): List<V>?{
        val graph = hashMapOf<V, List<V>>()
        graph.putAll(values)

        var searchQueue: Deque<V> = LinkedList()
        graph[key]?.let { 
            searchQueue += it
        }
        val searched = LinkedHashSet<V>()
    
        while (searchQueue.isNotEmpty()){
            val current = searchQueue.pop()
    
            if (!searched.contains(current)){
                if (searchFunction(current)){
                    searched.add(current)
                    return searched.toList()
                } else {
                    graph[current]?.let { 
                        searchQueue += it
                    }
                    searched.add(current)
                }
            }
        }
        return null
    }
}
