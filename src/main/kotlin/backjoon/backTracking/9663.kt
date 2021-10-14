package backjoon.backTracking

fun main() {
    val n = readLine()!!.toInt()
    val arr2d = Array(n){ BooleanArray(n){true} }
    var count = 0
    var tmp = Array(n+1){ Array(n){ BooleanArray(n){true} } }

    fun findNextPosition(arr2d: Array<BooleanArray>, queenCnt: Int, x: Int, y: Int){
//        println("depth : $queenCnt x: $x y: $y")
//        arr2d.forEach { println(it.contentToString())  }
//        println("----------------------------")
        if (queenCnt == n){
            count++
            return
        }
        for (y in 0 until n){
            for (x in 0 until n){
                if (arr2d[y][x]) { // 다음 true 가 있다면
                    //tmp에 저장
                    getTmp(tmp[queenCnt], arr2d)
                    deletePosition(arr2d, n, x, y)
                    // findNextPosition
                    findNextPosition(arr2d,queenCnt + 1, x, y)
                    //이전 상태로 돌아옴
                    getBack(arr2d, tmp[queenCnt])
                }
            }
        }
    }

    findNextPosition(arr2d, 0, 0 ,0)

    fun factorial(n: Int): Int{
        if (n==1) return 1
        return n*factorial(n-1)
    }
    print(count/factorial(n))
}

fun getTmp(tmp: Array<BooleanArray>, arr2d: Array<BooleanArray>){
    for(y in arr2d.indices){
        for(x in arr2d.indices){
            tmp[y][x] = arr2d[y][x]
        }
    }
}


fun getBack(arr2d: Array<BooleanArray>, tmpArr: Array<BooleanArray>){
    for(y in arr2d.indices){
        for(x in arr2d.indices){
            arr2d[y][x] = tmpArr[y][x]
        }
    }
}


fun deletePosition(arr2d: Array<BooleanArray>, n:Int, x: Int, y: Int){
    for (i in 0 until n) {
        // x 축 삭제
        if(arr2d[y][i] && i != x) arr2d[y][i] = false
        // y 축 삭제
        if(arr2d[i][x] && i != y) (arr2d[i][x]) = false
    }
    // 대각선 삭제
    var i = 0
    var j = 0
    var k = 0
    var l = 0
    //감감
    while (x - i >= 0 && y - i >= 0){
        if (arr2d[y-i][x-i]) arr2d[y-i][x-i] = false
        i++
    }
    //증증
    while (x + j < n && y + j < n){
        if (arr2d[y+j][x+j]) arr2d[y+j][x+j] = false
        j++
    }
    //증감
    while (x + k < n && y - k >= 0){
        if (arr2d[y-k][x+k]) arr2d[y-k][x+k] = false
        k++
    }
    //감증
    while (x - l >= 0 && y + l < n){
        if (arr2d[y+l][x-l]) arr2d[y+l][x-l] = false
        l++
    }
}


