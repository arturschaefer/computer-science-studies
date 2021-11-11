package liskov_substitution.error

class Tank: Car() {
    override fun enableTurboMode() {
        //Error: there is no turbo inside a tank
    }

    override fun stopTheCar() {
        TODO("Not yet implemented")
    }
}