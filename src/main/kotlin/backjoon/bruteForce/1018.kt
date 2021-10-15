package backjoon.bruteForce

fun main() {
    val (n, m) = readLine()!!.split(' ').map{ it.toInt() } // n 세로 m 가로
    val checkW = Array(8){
        if (it % 2 ==0 ) CharArray(8){ if (it % 2 == 0) 'W' else 'B' }
        else CharArray(8){ if (it % 2 == 0) 'B' else 'W' }
    }
    val checkB = Array(8){
        if (it % 2 ==0 ) CharArray(8){ if (it % 2 == 0) 'B' else 'W' }
        else CharArray(8){ if (it % 2 == 0) 'W' else 'B' }
    }

    val arr = Array(n){readLine()!!.toCharArray()}
    var ans = 65

    fun makeBoard(x:Int, y:Int): Array<CharArray>{
        val tmpArr = Array(8){ CharArray(8) }
        for (i in x..x+7){
            for (j in y..y+7){
                tmpArr[j-y][i-x] = arr[j][i] // copy
            }
        }
        return tmpArr
    }

    // Board 와 check 와 비교
    fun compareBoard(tmpArr: Array<CharArray>, check: Array<CharArray>): Int{
        var count = 0
        for (i in 0..7){
            for (j in 0..7){
                if (tmpArr[j][i] != check[j][i]) count += 1
            }
        }
        return count
    }

    // find 8*8
    fun findBoard(){
        for (i in 0 until m-7){
            for (j in 0 until n-7){
                if (ans == 0) {
                    break
                }
                val tmpArr = makeBoard(i,j)
                if (ans > compareBoard(tmpArr,checkB)) ans = compareBoard(tmpArr,checkB)
                if (ans > compareBoard(tmpArr,checkW)) ans = compareBoard(tmpArr,checkW)
            }
        }
    }
    findBoard()
    print(ans)
}