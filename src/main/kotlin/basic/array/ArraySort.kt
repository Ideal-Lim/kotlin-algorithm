package basic.array

data class Person(val name : String, val age : Int)

fun main() {
    val arr = arrayOf(6,3,4,1,7,3,1,2)
    // 오름차순으로 정렬된 배열 생성
    val sortedArray = arr.sortedArray()
    // 내림차순으로 정렬된 배열 생성
    val descendingArray = arr.sortedArrayDescending()

    // 기존 배열을 정렬
    arr.sort()
    // sort(시작 Index, 종료 Index) 종료 인덱스 포함 x
    arr.sort(1,7) // [6, 1, 1, 3, 3, 4, 7, 2]
    // array -> list 변환
    // val listFromArray : List<Int> = arr.toList()
    val sortedListFromArray : List<Int> = arr.sorted()
    val sortedDescendingListFromArray = arr.sortedArrayDescending()

    /**
     * 객체 프로퍼티로 정렬하기 -> sortBy / sortWith() 비교자 사용
     */

    val people = arrayOf(
        Person("철수", 16),
        Person("영수", 19),
        Person("안수", 17),
        Person("미수", 21),
        Person("정수", 24),
        Person("진수", 23),
    )
    //sortBy 로 정렬
    people.sortBy{ it.age }
    people.forEach { println(it) }
    people.sortBy{ it.name }
    people.forEach { println(it) }


}

