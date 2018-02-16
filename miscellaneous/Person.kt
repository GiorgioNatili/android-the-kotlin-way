class Person {
    var age: Int = 0
        set(value) {
            field = when {
                value < 18 -> 0
                value in 18..65 -> value
                else -> 100
            }
            actualAge = value
        }

    var supposedToStillWorking: Boolean = false
        get() = actualAge in 18..65

    var actualAge: Int = 0
}
