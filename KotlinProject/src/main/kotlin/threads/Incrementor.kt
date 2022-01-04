package threads

/**
 * synchronized(this) defines this (the Incrementor’s instance) as the lock object. Any thread that reaches this point,
 * locks the Incrementor instance, does the work defined in the code-block of synchronized and releases the lock.
 */
class Incrementor() {
    var sharedCounter: Int = 0
        private set

    fun updateCounterIfNecessary(shouldIActuallyIncrement: Boolean) {
        if (shouldIActuallyIncrement) {
            synchronized(this) {
                //only locks when needed, using the Incrementor`s instance as the lock.
                sharedCounter++
            }
        }
    }
}