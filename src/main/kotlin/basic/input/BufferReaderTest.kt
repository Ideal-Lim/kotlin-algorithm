package basic.input

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val array = IntArray(n)

    StringTokenizer(readLine()).run {
        for (i in 0 until n) {
            array[i] = nextToken().toInt()
        }
    }

    writer.write("${Arrays.stream(array).min().asInt} ${Arrays.stream(array).max().asInt}")
    writer.flush()
    writer.close()
    close()
}