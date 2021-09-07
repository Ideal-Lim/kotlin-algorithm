package algorithm.sort

import kotlin.time.ExperimentalTime

object ArrayTest {
    @ExperimentalTime
    fun reversedArrayTest(dataSize: Int){
        val reversedArray: Array<Int> = ArrayUtil.createReversedArray(dataSize)
        val reversedArray2: Array<Int> = reversedArray.copyOf()
        val reversedArray3: Array<Int> = reversedArray.copyOf()
        val reversedArray4: Array<Int> = reversedArray.copyOf()
        val reversedArray5: Array<Int> = reversedArray.copyOf()

        print("BubbleSort ")
        ArrayUtil.printMeasuredTime { SortAlgorithm.bubbleSort(reversedArray) }

        print("selectSort ")
        ArrayUtil.printMeasuredTime { SortAlgorithm.selectSort(reversedArray2) }

        print("InsertSort ")
        ArrayUtil.printMeasuredTime { SortAlgorithm.insertSort(reversedArray3) }

        print("QuickSort(첫 번째) ")
        ArrayUtil.printMeasuredTime { QuickSort.sortByFirst(reversedArray4) }

        print("QuickSort(중앙) ")
        ArrayUtil.printMeasuredTime { QuickSort.sortByMid(reversedArray5) }
    }

    @ExperimentalTime
    fun randomArrayTest(dataSize: Int){
        val randomArray: Array<Int> = ArrayUtil.createRandomArray(dataSize)
        val randomArray2: Array<Int> = randomArray.copyOf()
        val randomArray3: Array<Int> = randomArray.copyOf()
        val randomArray4: Array<Int> = randomArray.copyOf()
        val randomArray5: Array<Int> = randomArray.copyOf()
        val randomArray6: Array<Int> = randomArray.copyOf()

        print("BubbleSort ")
        ArrayUtil.printMeasuredTime { SortAlgorithm.bubbleSort(randomArray) }

        print("selectSort ")
        ArrayUtil.printMeasuredTime { SortAlgorithm.selectSort(randomArray2) }

        print("InsertSort ")
        ArrayUtil.printMeasuredTime { SortAlgorithm.insertSort(randomArray3) }

        print("QuickSort(첫 번째) ")
        ArrayUtil.printMeasuredTime { QuickSort.sortByFirst(randomArray4) }

        print("QuickSort(중앙) ")
        ArrayUtil.printMeasuredTime { QuickSort.sortByMid(randomArray5) }

    }
}