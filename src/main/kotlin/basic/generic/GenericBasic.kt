package basic.generic

//<in T> : 반공변성으로 선언
class Wrapper<in T>(val a: Int)
class Wrapper2<out T>(val a: T)

fun main(){
    val myList = mutableListOf<Number>()
    val myCollection = MyCollection(myList)

    val intNull: Int = 1
    myCollection.add(intNull)
}

class MyCollection<in T>(private val items: MutableList<T>){

    fun add(t: T){
        items.add(t)
    }
//
//    fun getValue(index: Int): T{ //error
//        return items[index]
//    }
}