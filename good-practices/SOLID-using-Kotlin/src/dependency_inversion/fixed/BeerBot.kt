package dependency_inversion.fixed

class BeerBot: DrinksBot {
    override fun dispense() {
        println("Dispensing 🍺")
    }
}
