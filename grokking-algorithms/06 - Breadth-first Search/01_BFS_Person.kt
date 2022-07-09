import java.util.Deque
import java.util.LinkedList

fun main() {

    val graph = hashMapOf<Person, List<Person>>(
        Person("you") to listOf(Person("alice"), Person("bob"), Person("claire")),
        Person("bob") to listOf(Person("anuj"), Person("peggy")),
        Person("alice") to listOf(Person("peggy")),
        Person("claire") to listOf(Person("thom", true), Person("jonny")),
        Person("anuj") to emptyList(),
        Person("peggy") to emptyList(),
        Person("thom", true) to emptyList(),
        Person("jonny") to emptyList(),
    )

    searchMangoSeller(Person("you"), graph)
}

// O(V+E) (V for number of vertices, E for number of edges)
fun searchMangoSeller(person: Person, graph: HashMap<Person, List<Person>>){
    val searchQueue: Deque<Person> = LinkedList()
    graph[person]?.let { 
        searchQueue += it
    }
    val searched = HashSet<Person>()

    while (searchQueue.isNotEmpty()){
        val current = searchQueue.pop()

        if (!searched.contains(current)){
            if (current.isMangoSeller){
                println("${current.name} is a Mango Seller")
                return
            } else {
                graph[current]?.let { 
                    searchQueue += it
                }
                searched.add(current)
            }
        }
    }
}

data class Person(val name: String, val isMangoSeller: Boolean = false) {
    override fun equals(other: Any?): Boolean = if (other is Person) other.name == name else false
}
