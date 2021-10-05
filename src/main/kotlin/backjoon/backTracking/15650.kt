package backjoon.backTracking


/**
 * 백준 15650번 - N 과 M (2)
 */
fun main() {

    val (n,m) = readLine()!!.split(' ').map{ it.toInt() }
    val tmpArr = IntArray(m)

    fun getCombination(depth: Int ,start: Int){
        if (m == depth){
            println(tmpArr.joinToString(" "))
            println(tmpArr.contentToString())
        }
        else {
            for (i in start..n){
                tmpArr[depth] = i
                getCombination(depth + 1, i + 1)
            }
        }
    }
    getCombination(0,1)
}

fun combinationByForLoop(){
    val arr = IntArray(4){i -> i + 1 }
    for (i in arr.indices){
        for (j in i+1 until arr.size)
            for (k in j+1 until arr.size){
                println("${arr[i]} ${arr[j]} ${arr[k]}")
            }
    }
}
