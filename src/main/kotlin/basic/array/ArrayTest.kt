package basic.array

fun main() {
    val arr1: Array<Int> = arrayOf(1, 2, 3)
    val arr3: IntArray
    val arr2 = arr1.plus(5, 6)
    for (element in arr2){
        println(element)
    }
}

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

