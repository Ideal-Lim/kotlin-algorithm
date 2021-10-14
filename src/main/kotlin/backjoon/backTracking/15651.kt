package backjoon.backTracking

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))){
    val (n,m) = readLine()!!.split(' ').map{ it.toInt() }
    val tmpArr = IntArray(m)
    fun getCombinationWithRepetition(depth: Int){
        if (m == depth){
            this.write(tmpArr.joinToString(" ") + "\n")
        }
        else{
            for (i in 1..n){
                tmpArr[depth] = i
                getCombinationWithRepetition(depth + 1)
            }
        }
    }
    getCombinationWithRepetition(0)
    this.flush()
    this.close()
}