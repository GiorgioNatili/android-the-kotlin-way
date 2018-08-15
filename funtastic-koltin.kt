val drink = prepareDrink("Mark",21)
val hashCode = drink.toString()

println(add(1)(2)) // prints out 3

val addOne = add(1)
val three = addOne(2)

println(three)

val tot = compose(double, increment)(3)

val greeter = { "Hello" }
val welcomeMessage = welcomeBuilder({ "Hello" }, "Mark")
println(welcomeMessage)


val surnames= listOf("Smith", "Vance")
var names = mutableListOf("Mary", "Steve")

val input = arrayOf("Mark", "Julia", "John", "Mark")
val uniqueNames = input.toSet()

mapOf("Mojito" to Drink("Mojito"), "Wodka soda" to Drink("Wodka Soda"))

val anotherTest: (name: String, surname: String) -> Unit =
        { name, surname -> println("$name $surname!")}

val name = uniqueNames.filter {
    it.startsWith("m", ignoreCase = true)
}.first()

val persons = uniqueNames.asSequence()
        .filter { it.startsWith("M") }
        .map { Person(it, 25) }
        .toList()

// val persons = listOf<Person>(Person("Mary"), Person("James"))
val lowercase = persons.first()?.let {
    it.name.toLowerCase()
}

val updatedPerson = persons.first().apply {
    this.age = 44
}

val adult = updatedPerson.takeIf { it.age > 21 }
val anotherAdult = updatedPerson.takeUnless { it.age < 21 }

val surname = sample_text.text.toString()
val citizienship= sample_text.text.toString()

notNull(name, surname) {
    // do something
}

val welcome = "Giorgio".sayHello()
print(welcome)
        
// ===========================================

data class Person(val name: String, var age: Int)        
        
fun notNull(vararg args: Any?, action: (args: Any?) -> Unit) {
    when {
        args.filterNotNull().size == args.size -> action(args)
    }
}

fun String.sayHello() = println("Hello $this!")

fun welcomeBuilder(greeter: () -> String, name: String) =
        "${greeter.invoke()} $name!"

// fun double(x: Int) = x * 2
val double = { n: Int -> n*2 }
val increment = { n: Int -> n + 1 }

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun add(a:Int) = { b:Int -> a+b }

fun prepareDrink(name: String, age: Int): Drink? = if(age > 21) Drink(name) else null

data class Drink(val name: String)
data class Person(val name: String, var age: Int)

fun isBlank(s: String?) : Boolean {
    return s.isNullOrBlank()
}

fun isBlank(vararg strings: String) : Boolean {
    return strings.isEmpty() ||
            strings.any { isBlank(it) }
}
