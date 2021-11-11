package dependency_inversion.fixed

class RoboPub(private val drinksBots: List<DrinksBot>) {
    fun dispenseDrinks() {
        drinksBots.forEach { it.dispense() }
    }
}