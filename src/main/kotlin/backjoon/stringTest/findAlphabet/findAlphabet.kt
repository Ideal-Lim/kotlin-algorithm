package backjoon.stringTest.findAlphabet

fun main(){
    val list = MutableList(26){-1}
    var indexOfWord = 0
    readLine()!!.forEach{
        val indexOfAlphabet = it.toInt() - 97 // a의 ascii 97
        if (list[indexOfAlphabet] == -1){
            list[indexOfAlphabet] = indexOfWord
        }
        indexOfWord++
    }
    list.forEach { print("$it ") }
}