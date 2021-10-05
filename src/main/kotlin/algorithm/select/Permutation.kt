package algorithm.select

import java.util.Arrays




/**
 * 순열
 */
//arr: 선택할 요소가 들어있는 배열 , r: 뽑는 횟수 , temp: 뽑은 요소를 추가할 임시 배열, depth: 현재(temp) 까지 뽑은 요소 개수, isUsed: booleanArray
fun makePermutation(arr: IntArray, r: Int, temp: IntArray, depth: Int, isUsed: BooleanArray) {
    if (r == depth) { // 탈출조건 : depth 가 r과 같아진 경우, 즉 하나의 순열 완성 tmp.size 써도 무방.
        for (num in temp) print("$num ")
        println()
    } else {
        for (i in arr.indices) {
            if (isUsed[i]) continue
            isUsed[i] = true
            temp[depth] = arr[i]
            makePermutation(arr, r, temp, depth + 1, isUsed)
            isUsed[i] = false
        }
    }
}