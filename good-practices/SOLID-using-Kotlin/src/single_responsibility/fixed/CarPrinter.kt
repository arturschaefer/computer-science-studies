package single_responsibility.fixed

class CarPrinter {
    fun printInformation(car: Car) {
        println("This is a ${car.model} built at ${car.year}")
    }
}