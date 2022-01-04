package threads

import kotlinx.coroutines.*


// Reference: https://proandroiddev.com/synchronization-and-thread-safety-techniques-in-java-and-kotlin-f63506370e6d
private const val THREAD_NUMBER = 4
private const val THREAD_POOL_NAME = "synchronizationPool"
private const val SHARED_COUNTER_INCREMENT_TIMES = 1000
private const val COROUTINES_QUANTITY = 1000
private const val SHARED_COUNTER_SHOULD_BE = SHARED_COUNTER_INCREMENT_TIMES * COROUTINES_QUANTITY

fun main() {
//    sharedCounterBlocked()
//    sharedCounterVolatile()
//    sharedCounterSynchronizedMethod()
    sharedCounterSynchronizedStatement()
}

/**
 * - Get its current value,
 * - Store it in a temp variable, and increment the temp variable by 1,
 * - Save the temp variable to sharedCounter.
 *
 * But what if one thread gets the current value, and since we are in a multi-threaded world, another thread jumps in,
 * and tries to get the current value? Both of them will get the same value! So each of them increment that value by 1,
 * and store the same value.
 */
fun sharedCounterBlocked() = runBlocking {
    var sharedCounter = 0
    val scope = coroutineScopeFactory()

    scope.launch {
        val coroutines = createCoroutinesList {// create 1000 coroutines (light-weight threads).
            launch {
                for (i in 1..SHARED_COUNTER_INCREMENT_TIMES) { // Increment the sharedCounter 1000 times.
                    sharedCounter++
                }
            }
        }

        coroutines.forEach { coroutine ->
            coroutine.join() // wait for all coroutines to finish their jobs.
        }
    }.join()

    println("The number of shared counter should be $SHARED_COUNTER_SHOULD_BE, but actually is $sharedCounter")
}

/**
 * Volatile fields provide memory visibility and guarantee that the value that is being read, comes from the main memory
 * and not the cpu-cache, so the value in cpu-cache is always considered to be dirty, and It has to be fetched again.
 *
 * Volatiles do not help in our scenario, because even though the readers read the latest value from memory, other
 * threads can still read the same value while another thread is trying to increment
 */

@Volatile
var sharedCounter: Int = 0
fun sharedCounterVolatile() = runBlocking {
    val scope = coroutineScopeFactory() // We want our code to run on 4 threads
    scope.launch {
        val coroutines = createCoroutinesList {// create 1000 coroutines (light-weight threads).
            launch {
                for (i in 1..SHARED_COUNTER_INCREMENT_TIMES) { // Increment the sharedCounter 1000 times.
                    sharedCounter++
                }
            }
        }

        coroutines.forEach { coroutine ->
            coroutine.join() // wait for all coroutines to finish their jobs.
        }
    }.join()

    println("The number of shared counter should be $SHARED_COUNTER_SHOULD_BE, but actually is $sharedCounter")
}

/**
 * One solution is to use Java’s synchronized. There are two types of synchronization available in Java (and Kotlin).
 * Synchronized methods and synchronized statements.
 *
 * One thing to note about synchronized methods, is that the access to the whole method is restricted, even when there’s
 * no need for synchronization.
 */
var sharedCounterSynchronized = 0
@Synchronized
fun updateCounterSynchronized() {
    sharedCounterSynchronized++
}
fun sharedCounterSynchronizedMethod() = runBlocking {
    val scope = coroutineScopeFactory() // We want our code to run on 4 threads
    scope.launch {
        val coroutines = createCoroutinesList {// create 1000 coroutines (light-weight threads).
            launch {
                for (i in 1..SHARED_COUNTER_INCREMENT_TIMES) { // Increment the sharedCounter 1000 times.
                    updateCounterSynchronized()
                }
            }
        }

        coroutines.forEach { coroutine ->
            coroutine.join() // wait for all coroutines to finish their jobs.
        }
    }.join()

    println("The number of shared counter is $sharedCounterSynchronized, and it is equal to $SHARED_COUNTER_SHOULD_BE")
}

/**
 * As an example, let’s only increment the number when our iteration number is even.
 */
fun sharedCounterSynchronizedStatement() = runBlocking {
    val incrementor = Incrementor()
    val scope = coroutineScopeFactory() // We want our code to run on 4 threads
    scope.launch {
        val coroutines = createCoroutinesList {// create 1000 coroutines (light-weight threads).
            launch {
                for (i in 1..SHARED_COUNTER_INCREMENT_TIMES) { // Increment the sharedCounter 1000 times.
                    incrementor.updateCounterIfNecessary(i % 2 == 0)
                }
            }
        }

        coroutines.forEach { coroutine ->
            coroutine.join() // wait for all coroutines to finish their jobs.
        }
    }.join()

    println("The number of shared counter is ${incrementor.sharedCounter}")
}

/**
 * Create CoroutineScope with 4 threads by default
 */
private fun coroutineScopeFactory(
    threadNumber: Int = THREAD_NUMBER,
    threadPoolName: String = THREAD_POOL_NAME
): CoroutineScope {
    return CoroutineScope(newFixedThreadPoolContext(threadNumber, threadPoolName))
}

/**
 * Transform List<Int> to List<Job>
 */
private fun createCoroutinesList(action: () -> Job): List<Job> {
    return 1.rangeTo(COROUTINES_QUANTITY).map {
        action()
    }
}
