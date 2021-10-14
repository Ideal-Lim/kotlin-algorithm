import java.util.*
import kotlin.math.pow

class Heap<E>(capacity: Int = DEFAULT_CAPACITY, comparator: Comparator<in E?>? = null) {
    val array = arrayOfNulls<Object>(capacity)
    var size = 0

    // 받은 인덱스의 부모 노드 인덱스를 반환
    private fun getParent(index: Int): Int {
        return index / 2
    }

    // 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
    private fun getLeftChild(index: Int): Int {
        return index * 2
    }

    // 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
    private fun getRightChild(index: Int): Int {
        return index * 2 + 1
    }

    companion object {
        private const val DEFAULT_CAPACITY = 10 // 기본 용량
    }
}

fun main() {
    val digitN = arrayListOf<Int>(1,2,3,4,5,6)
    fun digitToNum(tmpDigit: ArrayList<Int>, firstDigit: Int): Int{
        if (digitN.size == 1) return firstDigit
        if (firstDigit == 0) return tmpDigit[0]

        val tmp = ArrayList<Int>(tmpDigit.size)
        for (i in tmpDigit.indices){
            tmp.add(tmpDigit[i] * (10.0.pow(tmpDigit.size-i-1)).toInt())
        }
        return tmp.sum() + (firstDigit * (10.0.pow(tmpDigit.size))).toInt()
    }

    println(digitToNum(digitN, 1))
}