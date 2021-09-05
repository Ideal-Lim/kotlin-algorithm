package binarysearch

import kotlin.system.measureTimeMillis
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

object BinarySearch {
//        val arr = arrayOf<Int>(1,2,3,4,5,6,7,8,9,10)
    val arr = Array<Int>(100000) { i -> i + 1 }
    val arrSize = arr.size
    fun binarySearchByWhile(target: Int, _arrSize: Int = arrSize - 1): Int{
            // 배열의 인덱스 범위
            var left = 0
            var right = _arrSize - 1

            // while 반복 문을 통한 이진 탐색
            while(left <= right){
                val mid = (left + right) / 2

                if (target == arr[mid]){
                    return mid // target 의 index 반환
                }
                else if (target >= arr[mid]){ // target 이 중앙값보다 클 때
                    left = mid + 1
                }
                else { // target 이 중앙값 보다 작을때
                    right = mid - 1
                }
            }
            return -1
    }

    fun binarySearchByRecursion(target: Int, left:Int = 0, right: Int = arr.size - 1): Int{
        if (left == right){
            return -1 // 탐색 실패
        }

        if (left <= right){
            val mid = (left + right) / 2

            if (target == arr[mid]){
                return mid
            }
            else if (target <= arr[mid]){
                return binarySearchByRecursion(target, left, arr[mid] - 1)
            }
            else if (target >= arr[mid]){
                return binarySearchByRecursion(target, arr[mid] + 1, right)
            }
        }
        return  -1
    }
}

@ExperimentalTime
fun main(){

    //while
    val measuredTime = measureTimedValue {
        BinarySearch.binarySearchByWhile(200000)
    }

    println("IndexOfTarget => ${measuredTime.value} || measured time ==>${measuredTime.duration}")

    //recursion
    val measuredTime2 = measureTimedValue {
        BinarySearch.binarySearchByRecursion(200000)
    }

    println("IndexOfTarget => ${measuredTime2.value} || measured time ==>${measuredTime2.duration}")

}

