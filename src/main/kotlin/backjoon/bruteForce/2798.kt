package backjoon.bruteForce

fun main() {
    val (n,m) = readLine()!!.split(' ').map{ it.toInt() }
    val cardNumList = readLine()!!.split(' ').map{ it.toInt() }
    val booleanArray = BooleanArray(n)
    var result = 0

    fun makeCombination(depth: Int, start: Int, tmp: ArrayList<Int>){
        if (depth == 3){
            var sum = 0
            tmp.forEach{ sum += cardNumList[it] }
            if (result < sum && sum <= m) result = sum
        }
        else {
            for (i in start until n){
                booleanArray[i] = true
                tmp.add(i)
                makeCombination(depth+1, i + 1, tmp)
                tmp.remove(i)
                booleanArray[i] = false
            }
        }
    }
    makeCombination(0,0,ArrayList<Int>(3))
    print(result)
}