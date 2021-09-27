package backjoon.stringTest.numOfWord

fun main() {
    var cnt = 0
    val wordList = readLine()!!
    wordList.forEach{
        if (it == ' '){
            cnt++
        }
    }
    val firstChar = wordList[0]
    val lastChar = wordList[wordList.lastIndex]
    when {
        firstChar == ' ' && lastChar == ' ' -> print(cnt - 1)
        firstChar == ' ' && lastChar != ' ' -> print(cnt)
        firstChar != ' ' && lastChar == ' ' -> print(cnt)
        firstChar != ' ' && lastChar != ' ' -> print(cnt + 1)
    }
}

