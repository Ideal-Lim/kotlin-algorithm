package backjoon.backTracking

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))){
    val (n,m) = readLine()!!.split(' ').map{ it.toInt() }
    val tmpArr = IntArray(m)
    fun getCombinationWithRepetition(depth: Int,start: Int){
        if (m == depth){
            this.write(tmpArr.joinToString(" ") + "\n")
        }
        else{
            for (i in start..n){
                tmpArr[depth] = i
                getCombinationWithRepetition(depth + 1, i)
            }
        }
    }
    getCombinationWithRepetition(0, 1)
    this.flush()
    this.close()
}