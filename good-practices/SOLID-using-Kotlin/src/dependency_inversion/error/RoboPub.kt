package dependency_inversion.error

class RoboPub {
    private val wineBot = WineBot()
    private val beerBot = BeerBot()

    fun dispenseDrinks(){
        wineBot.dispenseWine()
        beerBot.dispenseBeer()
    }
}