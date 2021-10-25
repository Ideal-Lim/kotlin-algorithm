package backjoon.greedy

/**
 * 백준 13305번 주유소
 */

fun main() {
    val n = readLine()!!.toInt()
    val distances = readLine()!!.split(' ').map{ it.toLong() }
    val prices = readLine()!!.split(' ').map{ it.toLong() }

    var currPrice = prices[0]
    var ans = 0L

    for (i in distances.indices){
        val nextPrice = prices[i+1]
        if (currPrice < nextPrice) {
            ans += currPrice * distances[i]
        } else {
            ans += currPrice * distances[i]
            currPrice = nextPrice
        }
    }
    print(ans)
}

