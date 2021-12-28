package rxjava

import io.reactivex.rxjava3.core.Observable

object FilteringOperators {

    fun observableFilter(requiredAge: Int = 25) {
        println("Observable.filter()")
        println("Filter data when users have more than 25")
        Observable.fromIterable(Data.users).filter { it.age > requiredAge }.subscribe { println(it) }
    }

    fun observableTake(takeItems: Long = 3L) {
        println("Observable.take()")
        println("take 3 items from an Observable list")
        Observable.fromIterable(Data.users).take(takeItems).subscribe { println(it) }
    }

    fun observableSkip(skipFirst: Long = 3L) {
        println("Observable.skip()")
        println("skip the firsts 3 items")
        Observable.fromIterable(Data.users).skip(skipFirst).subscribe { println(it) }
    }

    fun observableSkipLast(skipFirst: Int = 3) {
        println("Observable.skip()")
        println("skip the last 3 items")
        Observable.fromIterable(Data.users).skipLast(skipFirst).subscribe { println(it) }
    }

    fun observableElementAt(index: Long = 3L) {
        println("Observable.elementAt()")
        println("return the third element")
        Observable.fromIterable(Data.users).elementAt(index).subscribe { println(it) }
    }

    fun observableDistinct() {
        println("Observable.distinct()")
        println("Emit just distinct values")
        Observable.just('a', 'a', 'b', 'b', 'c', 'c').distinct().subscribe {
            println(it)
        }
    }
}