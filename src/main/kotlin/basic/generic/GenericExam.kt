package basic.generic

class Wrapping<T>(var item: T)

open class Car(){
    fun powerOn(){
        println("시동을 겁니다")
    }
}

class Porsche(val name: String) : Car()

class Audi(val name: String) : Car()


fun printCar(wrapping: Wrapping<out Car>){
    val car = wrapping.item
    println(car)
}

fun changeCar(box: Wrapping<in Car>){
    // val car: Car = box.item //error!
    box.item = Car()
}

fun main() {
    val wrappingCar = Wrapping(Car())
    val wrappingPorsche = Wrapping(Porsche("911"))
    val wrappingAudi = Wrapping(Audi("A50"))

    printCar(wrappingCar)
    printCar(wrappingAudi)

    changeCar(wrappingCar)
    // changeCar(wrappingPorsche) error!
}

interface InterfaceA
interface InterfaceB

class HandlerA: InterfaceA, InterfaceB
class HandlerB: InterfaceB


class GenericClass<T> where T: InterfaceA, T: InterfaceB {
    fun genericMethod(a: T){
        // ...
    }
}