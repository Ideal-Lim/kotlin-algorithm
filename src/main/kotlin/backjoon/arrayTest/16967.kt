package backjoon.arrayTest

fun main() {
    val (h,w,x,y) = readLine()!!.split(' ').map { it.toInt() }

    val arrA = Array(h){IntArray(w)}
    val arrB = Array(h+x){IntArray(w+y)}

    for (j in 0 until h+x) {
        readLine()!!.split(' ').map{ it.toInt() }.run {
            for (i in 0 until w+y){
                arrB[j][i] = this[i]
            }
        }
    }
    //안겹치는 부분 처리
    for (j in 0 until h){
        for (i in 0 until w){
            arrA[j][i] = arrB[j][i]
        }
    }
    //겹치는 부분 처리
    for (j in x until h){
        for (i in y until w){
            arrA[j][i] = arrB[j][i] - arrA[j-x][i-y]
        }
    }

    //출력
    for (j in 0 until h){
        for (i in 0 until w){
            print("${arrA[j][i]}" + " ")
        }
        print("\n")
    }
}