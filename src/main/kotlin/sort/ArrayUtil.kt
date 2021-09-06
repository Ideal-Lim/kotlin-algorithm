package sort

import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

object ArrayUtil {
    //swap 함수
    fun Array<Int>.swap(index1 : Int, index2: Int){
        if (index1 != index2){
            val tmp = this[index1]
            this[index1] = this[index2]
            this[index2] = tmp
        }
    }
    //출력함수
    fun Array<Int>.print() {
        var str = "["
        for (i in this.indices) {
            str += this[i]
            if (i < this.size - 1) {
                str = "$str,"
            }
        }
        println("$str]")
    }

    fun createRandomArray(dataSize: Int, rangeOfStart: Int = 0, rangeOfEnd: Int = dataSize - 1): Array<Int> {
        println("데이터 개수: $dataSize 랜덤 array 생성")
        return Array(dataSize) { Random.nextInt(rangeOfStart, rangeOfEnd) }
    }

    fun createReversedArray(dataSize: Int): Array<Int>{
        println("데이터 개수: $dataSize 역순 array 생성")
        return Array(dataSize) {i -> i + 1 }.reversedArray()
    }

    @ExperimentalTime
    fun printMeasuredTime(func : () -> Unit){
        val measuredTime = measureTimedValue{
            func()
        }
        println("measured Time : ${measuredTime.duration}")
    }

}