package single_responsibility.error

class Car(val model: String, val year: Int) {
    fun printInformation() {
        println("This is a $model built at $year")
    }
}