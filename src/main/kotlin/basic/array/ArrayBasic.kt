package basic.array

import java.util.*

/**
 * 본 코드는 'Do it! 코틀린 프로그래밍 with | 황영덕 '의 내용입니다.
 */

fun main(){
    /**
     * 1차원 배열
     */
    //arrayOf() 생성자 : 배열의 값을 알고 있을 때
    val arr = arrayOf(1,2,3,4)
    val arr2 = arrayOf("a", "b", "c")

    // Array(요소 개수, 초깃 값) 생성자
    val arr3 = Array(3){i -> i + 1} // [1,2,3]
    val arr4 = Array(3) { 0 } // [0,0,0]

    val arrOfNulls = arrayOfNulls<Int>(3) // [null,null,null]
    // primitive array ex) IntArray -> int[]
    val intArray = intArrayOf(1,2,3,4)

    /**
     * 다차원 배열
     */
    val array1 = arrayOf(1,2,3)
    val array2 = arrayOf(4,5,6)
    val array3 = arrayOf(7,8,9)

    val array2d = arrayOf(array1, array2, array3)

    /**
     * 유용한 배열 메서드
     */
    // print 1차원 배열
    println(array1.contentToString())
    println(Arrays.toString(array1))

    // print 다차원 배열
    println(array2d.contentDeepToString())
    println(Arrays.deepToString(array2d))

    //베열 합 / 평균
    println(array1.sum()) // 6
    println(array1.average()) // 2

    // plus() : 배열의 끝에 하나의 요소를 추가한 새 배열 생성
    val plusArray = arr.plus(4) // [1,2,3,4]
    println(arr.contentToString()) // [1,2,3]

    // sliceArray(범위) : 해당 범위에 새로운 배열 생성﻿
    val sliceArray = arr.sliceArray(0..1) // [1,2]

    // contains() : 배열에 해당 요소가 있는지 확인
    println(arr.contains(1)) // true

    // in 연산자를 사용해 검사할 수 도 있다.
    println(0 in arr) // False

    // reversed() ,reverse() : 역순의 배열 생성
    arr.reverse() // 기존 배열 역순 처리
    println(arr.contentToString())
    val reversedArray = arr.reversedArray() // 역순의 새로운 배열 생성성
}