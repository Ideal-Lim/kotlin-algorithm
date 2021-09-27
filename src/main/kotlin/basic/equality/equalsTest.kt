package basic.equality

fun main() {
    val a: String = "hello world!"
    val b: String = "hello world!"

    println(a == b) // true
    println(a === b) // true

    val c = A()
    val d = A()

    println(c == d) // false
    println(c === d) // false
}

class A