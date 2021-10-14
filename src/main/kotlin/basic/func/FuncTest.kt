package basic.func

fun main() {
    val arr = IntArray(5)
    val arr2 = arr.copyOf()
    fun deleteArr(arr: IntArray){
        for (i in arr.indices){
            arr[i] = 1
        }
    }

    deleteArr(arr)

    println(arr.contentToString())
    println(arr2.contentToString())

}