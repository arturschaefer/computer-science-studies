package rxjava.operators

import io.reactivex.rxjava3.core.Observable
import rxjava.Data

object TransformationOperators {
    fun observableMap(ageMultiplier: Int = 2) {
        println("Observable.map()")
        println("Mapping -> age *= 2")
        Observable.fromIterable(Data.users).map {
            it.age *= ageMultiplier
            it
        }.subscribe { println(it) }
    }

    fun observableFlatMap() {
        println("Observable.flatMap()")
        println("We flatMap Observable.fromIterable to a new Observable from upgrade()")
        println("In other words, we iterable from each User Observable and upgrade their salaries")
        Observable.fromIterable(Data.users).flatMap { upgrade(it) }.subscribe { println(it) }
    }

    fun observableConcatMap() {
        println("Observable.concatMap()")
        println("This operator does the same thing as flatMap")
        println("The main difference is it keeps the order in which it receives the data")
        Observable.fromIterable(Data.users).concatMap { upgrade(it) }.subscribe { println(it) }
    }

    fun observableGroupBy(key: String = "Sales") {
        println("Observable.groupBy()")
        println("GroupBy data when key is Sales")
        Observable.fromIterable(Data.users)
            .groupBy { it.location }
            .subscribe { if (it.getKey() == key) it.subscribe { println(it) } }
    }

    fun observableBuffer(bufferSize: Int = 3) {
        println("Observable.buffer()")
        println("Buffer data with each 3 items at a time")
        Observable.fromIterable(Data.users).buffer(bufferSize).subscribe { println(it) }
    }

    private fun upgrade(user: Data.User): Observable<Data.User> {
        when {
            user.age > 30 -> user.salary = user.salary * 3
            user.age > 25 -> user.salary = user.salary * 2
            else -> user.salary = user.salary * 4
        }
        return Observable.just(user)
    }
}