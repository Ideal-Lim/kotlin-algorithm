package backjoon.math

/**
 * 백준 2581번
 */
fun main(){
    var sum = 0
    var minPrimeNum = 0
    for (num in readLine()!!.toInt()..readLine()!!.toInt()){
        if (findPrimeNum(num)) sum += num
        if (minPrimeNum == 0 && findPrimeNum(num)) minPrimeNum = num
    }
    if (sum != 0) print("$sum\n$minPrimeNum") else print(-1)
}

