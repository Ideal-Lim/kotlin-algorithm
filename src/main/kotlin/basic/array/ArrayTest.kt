package basic.array

fun main() {
    val arr1: Array<Int?> = arrayOfNulls(3)
    val arr2: IntArray = intArrayOf(1,2,3)

    val arr3 = arrayOfNulls<Int>(3)
}

//원하는 인덱스에 요소 삽입
fun <T> Array<T>.plus(elementOfInsert: T, index: Int): Array<T> {
    val arraySize = size
    val result = java.util.Arrays.copyOf(this, size + 1)
    if (index <= size){
        for ((i, element) in this.withIndex()){
            when {
                i >= index -> result[i+1] = element
            }
        }
        result[index] = elementOfInsert
    } else {
        throw ArrayIndexOutOfBoundsException()
    }
    return result
}

