package backjoon.greedy

data class Time(val startTime: Int, val endTime: Int):Comparable<Time>{
    override fun compareTo(other: Time): Int =
        when {
            this.endTime > other.endTime -> 1
            this.endTime < other.endTime -> -1
            else -> when {
                this.startTime > other.startTime -> 1
                else -> -1
            }
        }
}

fun main() {
    val n = readLine()!!.toInt()
    val timeList = ArrayList<Time>(n)

    repeat(n){
        val (startTime, endTime) = readLine()!!.split(' ').map{it.toInt()}
        timeList.add(Time(startTime, endTime))
    }

    timeList.sort()

    var end = 0
    var count = 0

    for (i in 0 until n){
        val next = timeList[i]
        if (end <= next.startTime){
            end = next.endTime
            count++
        }
    }

    print(count)
}