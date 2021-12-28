import rxjava.CreationOperators.observableCreate
import rxjava.CreationOperators.observableFromIterable
import rxjava.CreationOperators.observableJust
import rxjava.CreationOperators.observableRange
import rxjava.CreationOperators.observableRepeat
import rxjava.FilteringOperators.observableDistinct
import rxjava.FilteringOperators.observableElementAt
import rxjava.FilteringOperators.observableFilter
import rxjava.FilteringOperators.observableSkip
import rxjava.FilteringOperators.observableSkipLast
import rxjava.FilteringOperators.observableTake
import rxjava.TransformationOperators.observableBuffer
import rxjava.TransformationOperators.observableConcatMap
import rxjava.TransformationOperators.observableFlatMap
import rxjava.TransformationOperators.observableGroupBy
import rxjava.TransformationOperators.observableMap

fun main(args: Array<String>) {
    println("RxJava Operators")

    // Creation Operators
//    observableJust()
//    observableFromIterable()
//    observableRepeat()
//    observableRange()
//    observableCreate()

    // Transformation Operators
//    observableMap()
//    observableFlatMap()
//    observableConcatMap()
//    observableGroupBy()
//    observableBuffer()

    // Filtering Operators
//    observableFilter()
//    observableTake()
//    observableSkip()
//    observableSkipLast()
    observableElementAt()
    observableDistinct()
}

