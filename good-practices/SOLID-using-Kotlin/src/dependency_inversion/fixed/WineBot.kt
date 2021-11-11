package dependency_inversion.fixed

class WineBot: DrinksBot{
    override fun dispense() {
        println("Dispensing 🍷")
    }
}