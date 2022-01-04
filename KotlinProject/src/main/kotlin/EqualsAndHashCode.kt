fun main() {
    objectEquals()
}

fun stringsEquals() {
    val nameOne = "Andrew"
    val nameTwo = "Andrew"

    if (nameOne == nameTwo) {
        println("nameOne == nameTwo -> true")
        println("HashCode:\nnameOne -> ${nameOne.hashCode()}\nnameTwo -> ${nameTwo.hashCode()}\n")
    }

    val nameThree = "Maria"
    val nameFour = "Julie"

    if (nameThree != nameFour) {
        println("nameThree == nameFour -> false")
        println("HashCode:\nnameThree -> ${nameThree.hashCode()}\nnameFour -> ${nameFour.hashCode()}")
    }
}

fun objectEquals() {
    val userModifiedOne = UserModified("Artur")
    val userModifiedTwo = UserModified("Artur")

    println(
        "userModifiedOne(hashCode ${userModifiedOne.hashCode()}) " +
                "== userModifiedTwo (hashCode ${userModifiedTwo.hashCode()}) " +
                "-> ${userModifiedOne == userModifiedTwo}"
    )

    val userCommonOne = UserCommon("Artur")
    val userCommonTwo = UserCommon("Artur")

    println(
        "userCommonOne(hashCode ${userCommonOne.hashCode()}) " +
                "== userCommonTwo (hashCode ${userCommonTwo.hashCode()}) " +
                "-> ${userCommonOne == userCommonTwo}"
    )
}

class UserCommon(private val name: String)

class UserModified(private val name: String) {
    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return this.hashCode() == other.hashCode()
    }
}