package rxjava.operators

import io.reactivex.rxjava3.core.Observable
import rxjava.Data

object CreationOperators {
    fun observableCreate() {
        println("Observable.create<T>")
        Observable.create<Data.User> { emitter ->
            Data.users.forEach { emitter.onNext(it) }
        }.subscribe { println(it) }
    }

    fun observableRange(startAt: Int = 0, count: Int = 3) {
        println("Observable.range()")
        Observable.range(startAt, count).subscribe { println(it) }
    }

    fun observableRepeat(repeatTimes: Long = 3L) {
        println("Observable.repeat()")
        Observable.just("I am emitted").repeat(repeatTimes).subscribe { println(it) }
    }

    fun observableFromIterable() {
        println("Observable.fromIterable()")
        Observable.fromIterable(Data.users).subscribe { println(it) }
    }

    fun observableJust() {
        println("Observable.just()")
        Observable.just(Data.users).subscribe { println(it) }
    }
}