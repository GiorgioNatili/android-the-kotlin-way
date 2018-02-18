open class Pet {
    var owner: String = ""
}

interface Dog {
    fun waiveTail() = println("Waiving my tail")
}

interface Cat {
    fun purring() = println("Purring")
}

class GermanShepherd : Pet(), Dog
class Siamese: Pet(), Cat
