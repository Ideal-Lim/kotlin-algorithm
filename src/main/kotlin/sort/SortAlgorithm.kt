package sort

import sort.ArrayUtil.print
import sort.ArrayUtil.printMeasuredTime
import sort.ArrayUtil.swap
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

object SortAlgorithm {
    fun bubbleSort(arr : Array<Int>): Array<Int>{
        var temp: Int
        // n-1 번 시행
        for (i in arr.indices){
            // i 회차 때 바꾸는 횟수 ex) 1회 차 때 n - 1, 2회 차 때 n-2
            for (j in 1 until arr.size - i){
                // 만약 오른쪽 값이 왼쪽 값보다 작을 경우
                if (arr[j] < arr[j-1]){
                    //교환
                    temp = arr[j]
                    arr[j] = arr[j-1]
                    arr[j - 1] = temp
                }
            }
        }
        return arr
    }

    fun selectSort(arr: Array<Int>): Array<Int>{
        var temp: Int
        // 작은 값의 index 를 담을 변수이다
        var tempIndex: Int

        // n-1 번 실행
        for (i in arr.indices){
            temp = arr[i]
            tempIndex = i
            // 비교
            for (j in 1 until arr.size - i){
                // temp 에 저장된 값보다 작은 경우
                if (temp > arr[j + i]) {
                    //temp, tempIndex 에 최솟값 및 최솟값 index 값 저장
                    temp = arr[j + i]
                    tempIndex = j + i
                }
            }
            // 최솟값과 arr[i] swap
            // 최솟값 위치에 arr[i] 값 대입
            arr[tempIndex] = arr[i]
            // arr[i] 자리에 temp 값 대입
            arr[i] = temp
        }
        return arr
    }

    fun insertSort(arr: Array<Int>): Array<Int>{
        var temp: Int
        var j: Int

        //n-1 번 실행 (카드 뽑기 횟수)
        for (i in 1 until arr.size){
            //1. 데이터 정렬 대상 선택 (카드 선택)
            temp = arr[i]
            j = i-1
            // 삽입할 위치를 찾으면서 이전 값들을 땡겨옴
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j]
                j--
            }
            // 삽입할 위치에 값 삽입
            arr[j+1] = temp
        }
        return arr
    }

}

@ExperimentalTime
fun main(){
    ArrayTest.reversedArrayTest(7000)
}


