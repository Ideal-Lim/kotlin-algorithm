import java.util.*

fun main(){
    val sc = Scanner(System.`in`)

    // 테스트 개수 C
    val testNum = sc.nextInt()
    val list = mutableListOf<String>()
    for (test in 0 until testNum){
        val n = sc.nextInt()
        val scores = IntArray(n)

        for(i in 0 until n){
            scores[i] = sc.nextInt()
        }
        val average = (scores.sum() / n)
        var upAverageStudent = 0.toFloat()
        for (i in 0 until n){
            if (scores[i] > average ){
                upAverageStudent++
            }
        }
        list.add(String.format("%.3f", upAverageStudent/n*100)+"%")
    }
    list.forEach { println(it) }
}


