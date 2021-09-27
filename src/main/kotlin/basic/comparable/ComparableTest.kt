package basic.comparable

/**
 * Comparable 인터페이스
객체에서 원하는 자료형으로 비교하기 위해, Comparable 인터페이스를 사용할 수 있다.
Comparable 인터페이스는 같은 자료형의 다른 객체 하나를 인자로 받아와 비교하는 compareTo 함수를 사용한다.
a.comparable(b) 는 a가 b보다 작을 때는 0보다 작은 수, a와 b가 같으면 0, a가 b보다 크면 0보다 큰 수를 반환한다.
Comparable 인터페이스는 다음과 같이 구현되어 있다.
 */

class User(var id: Int, var name: String) : Comparable<User> {

    override fun compareTo(other: User): Int =
        when {
            this.id > other.id -> 1
            this.id < other.id -> -1
            else -> 0
        }
}

fun main() {
    val user1 = User(1, "민수")
    val user2 = User(2, "영희")

    println(user1 > user2) // false
    println(user1 == user2) // false
    println(user1 < user2) // true
    println(user1.compareTo(user2)) // -1
}