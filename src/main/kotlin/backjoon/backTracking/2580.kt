package backjoon.backTracking

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*
import kotlin.system.measureTimeMillis


/**
 * 2580번 스도쿠
 */
class Zero(val position: Pair<Int,Int>, var check: BooleanArray)
fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var zeroPosition = ArrayList<Pair<Int, Int>>(20)

    var boxThreeByThree = Array(9) { ArrayList<Pair<Int, Int>>() }

    val board = Array<IntArray>(9) { y ->
        readLine()!!.split(' ').mapIndexed { x, num ->
            if (num == "0") {
                zeroPosition.add(x to y)
                val a = x / 3
                val b = y / 3

                boxThreeByThree[a + b * 3].add(x to y)

                num.toInt()
            } else num.toInt()
        }.toIntArray()
    }


    val zeroPositionList = ArrayList<Zero>(zeroPosition.size) // check

    // 3*3
    // find0in3*3 -> check
    findBox3By3(boxThreeByThree, board, zeroPositionList)

    // find Line
    // Todo.find Line
    val zeroPositionCheck = BooleanArray(zeroPositionList.size)
    var findZeroCount = 0

    while (findZeroCount != zeroPositionList.size) {
        for ((i, zero) in zeroPositionList.withIndex()) {
            if (!zeroPositionCheck[i]) {
                if (findLine(zero, board)) {
                    zeroPositionCheck[i] = true
                    findZeroCount += 1
                }
            }
        }
    }

    for (i in 0..8) {
        for (j in 0..8) {
            bw.write("${board[i][j]} ")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

fun findBox3By3(boxThreeByThree: Array<ArrayList<Pair<Int,Int>>>, board: Array<IntArray>, checkNumList: ArrayList<Zero>){
    for (x in 0..2){
        for (y in 0..2){
            for (position in boxThreeByThree[x + y*3]){
                val check = Zero(position, checkNum3By3(x, y, board))
                if (findPossibleNum(check.check).first == 1) changeNum(findPossibleNum(check.check).second, position, board)
                else checkNumList.add(Zero(position, checkNum3By3(x, y, board)))
            }
        }
    }
}

fun checkNum3By3(boxX: Int, boxY: Int, board: Array<IntArray>): BooleanArray{
    val check = BooleanArray(10)
    for (i in 0..2){
        for (j in 0..2){
            check[board[boxY*3 + i][3*boxX+j]] = true
        }
    }
    return check
}

fun findPossibleNum(check: BooleanArray): Pair<Int, Int>{
    var count = 0
    var possibleNum = 0
    for (i in 1..9){
        if (!check[i]) {
            count++
            possibleNum = i
        }
    }
    if (count == 1) return count to possibleNum
    return count to 0
}

fun changeNum(num: Int, position: Pair<Int, Int>, board: Array<IntArray>){
        board[position.second][position.first] = num
}

fun findLine(zero: Zero, board: Array<IntArray>): Boolean{
    val check = BooleanArray(10)
    // x
    for (x in 0..8){
       if (!check[board[zero.position.second][x]]) check[board[zero.position.second][x]] = true
    }
    if (findPossibleNum(check).first == 1) {
        changeNum(findPossibleNum(check).second, zero.position, board)
        return true
    }
    //y
    for (y in 0..8){
        if (!check[board[y][zero.position.first]]) check[board[y][zero.position.first]] = true
    }

    if (findPossibleNum(check).first == 1) {
        changeNum(findPossibleNum(check).second, zero.position, board)
        return true
    }
    //대각선
    findDiagonal(check, zero.position, board)

    return if (findPossibleNum(check).first == 1){
        changeNum(findPossibleNum(check).second, zero.position, board)
        true
    } else{
        zero.check = check
        false
    }
}


fun findDiagonal(check: BooleanArray, position: Pair<Int, Int>, board: Array<IntArray>){
    val dx = intArrayOf(1,-1,1,-1)
    val dy = intArrayOf(1,-1,-1,1)
    var x = position.first
    var y = position.second

    for (i in 0..3){
        while (x != -1 && x != 9 && y != -1 && y != 9){
            if (!check[board[y][x]]) check[board[y][x]] = true
            x += dx[i]
            y += dy[i]
        }
    }
}



