package backjoon.greedy

fun mySolution11399() {
    val numList = ArrayList<String>(50)
    var num = ""
    var minusGroup = ArrayList<Int>()
    var plusGroup = ArrayList<Int>()

    // 숫자와 + - 로 나눔
    readLine()!!.forEach{
        if (it == '+' || it == '-') {
            numList.add(num)
            num = ""
            numList.add(it.toString())
        }
        else num += it.toString()
    }
    numList.add(num) // 마지막 숫자 추가

    /**
    * 숫자 분류
    * 아직 minus 가 안 나왔으면 status = 0 (plusGroup) 아니면 status = 1 (minusGroup)
    */
    var tmp = 0 // 숫자 합을 담을 임시 변수
    var status = 0 // 0 is plus 1 is minus

    for (num in numList){
        when {
            num == "-" -> if (status == 1) {
                minusGroup.add(tmp)
                tmp = 0
            } else {
                plusGroup.add(tmp)
                status = 1
                tmp = 0
            }
            num == "+" -> continue
            else -> tmp += num.toInt()
        }
    }
    if (status == 0) plusGroup.add(tmp) else minusGroup.add(tmp) // 마지막 숫자 처리

    //Ans
    print(plusGroup.sum() - minusGroup.sum())
}


fun shortSol() {
    val expression = readLine()!!

    var total = 0
    var num = 0
    var isSum = true // status
    for (c in expression) {
        if (c == '-' || c == '+') {
            total += if (isSum) num else -num
            if (isSum) isSum = c == '+'
            num = 0 // num 초기화
        }
        else {
            num = num * 10 + (c - '0') // 자리수 처리
        }
    }
    total += if (isSum) num else -num // 마지막 숫자 처리

    print(total)
}

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split("-")
    var min = str[0].split("+").sumOf { it.toInt() }

    for (i in 1 until str.size) {
        min -= str[i].split("+").sumOf { it.toInt() }
    }

    println(min)
}