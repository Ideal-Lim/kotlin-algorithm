package algorithm.sort

fun sortedByMode(arr: ArrayList<Pair<Int, Int>>): ArrayList<Pair<Int,Int>>{

    val tmp = ArrayList<Pair<Int,Int>>(arr.size)

    fun sortByFrequency(arr: ArrayList<Pair<Int, Int>>): List<Int> {
        val check = IntArray(10)
        val frequencyList = ArrayList<Pair<Int, Int>>()
        for (n in arr){
            check[n.first]++
            check[n.second]++
        }

        for ((num, frequency) in check.withIndex()){
            if (frequency != 0) frequencyList.add(frequency to num)
        }
        frequencyList.sortBy { it.first }
        return frequencyList.map{ it.second }
    }

    val sequenceByFrequency = sortByFrequency(arr)

    val check = BooleanArray(arr.size)
    for (num in sequenceByFrequency){
        for ((i,position) in arr.withIndex()){
            if (position.first == num || position.second == num) {
                if (!check[i]) {tmp.add(position); check[i] = true}
            }
        }
    }
    return tmp
}
