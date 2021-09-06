package sort

import sort.ArrayUtil.print
import sort.ArrayUtil.swap

object QuickSort {
    // pivot 값이 첫 번째 값
    fun sortByFirst(arr: Array<Int>, start: Int = 0, end: Int = arr.size - 1) {
        //탈출 조건 : 원소가 하나 남을 경우
        if (start >= end){
            return
        }
        //수색 작전 시작
        //Index
        // 기준 값으로 첫번째 값 설정
        val pivot: Int = start
        // 초깃값으로 왼쪽 시작값 / 오른쪽 마지막 값 설정
        var left: Int = start + 1
        var right: Int = end

        // 수색 작전 시작
        // 왼쪽과 오른쪽이 만날 때 동안 실행
        while (left < right){
            //왼쪽은 pivot 값보다 작은 값 pass
            // [방법 1]. left의 최댓값 end
            while (left <= end && arr[left] <= arr[pivot]){
                left++
            }
            //오른쪽은 pivot 보다 큰 값 pass
            while (arr[right] > arr[pivot] && pivot <= right){
                right--
            }

            // 만약 아직 수색병이 만나기 전
            if (left < right) {
                arr.swap(left, right)
            }
            // 만나거나 지나칠 때
            else {
                //피벗값 교체
                arr.swap(pivot,right)
            }
        }
        //분할 정복
        //왼쪽 배열
        sortByFirst(arr, start, right - 1)
        //오른쪽 배열
        sortByFirst(arr, right + 1, end)
    }

    // pivot 값이 중앙
    fun sortByMid(array: Array<Int>, start: Int = 0, end: Int = array.size - 1) {
        val index = partition(array, start, end)
        if (start < index - 1) {
            sortByMid(array, start, index - 1)
        }
        if (index < end) {
            sortByMid(array, index, end)
        }
    }

    private fun partition(array: Array<Int>, start: Int, end: Int): Int {
        var left = start
        var right = end
        val pivot = array[(left + right) / 2]

        while (left <= right) {
            while (array[left] < pivot) {
                left++
            }

            while (array[right] > pivot) {
                right--
            }

            if (left <= right) {
                array.swap(left,right)
                left++
                right--
            }
        }
        return left
    }
}