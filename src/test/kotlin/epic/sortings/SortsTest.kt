package epic.sortings

import epic.sortings.bubble.bubbleSort
import epic.sortings.count.countSort
import epic.sortings.insertion.insertionSort
import epic.sortings.merge.mergeSort
import epic.sortings.selection.selectionSort
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class InsertionKtTest: FunSpec ({
    val testSet = listOf(
        Pair(intArrayOf(1), intArrayOf(1)),
        Pair(intArrayOf(0), intArrayOf(0)),
        Pair(intArrayOf(), intArrayOf()),
        Pair(intArrayOf(0, 2, 4, 6, 8), intArrayOf(0, 2, 4, 6, 8)),
        Pair(intArrayOf(4, 2, 5, 1, 9, 2), intArrayOf(1, 2, 2, 4, 5, 9)),
        Pair(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),
        Pair(intArrayOf(1, 2, 3, 4, 0), intArrayOf(0, 1, 2, 3, 4)),
        Pair(intArrayOf(1, -2, 3, -4, 0), intArrayOf(-4, -2, 0, 1, 3)),
        Pair(intArrayOf(-1, 2, -3, -2, 0), intArrayOf(-3, -2, -1, 0, 2)),
        Pair(intArrayOf(5, -3, 2, 1, 0), intArrayOf(-3, 0, 1, 2, 5)),
        Pair(intArrayOf(-1, -2, -3, -4, -5), intArrayOf(-5, -4, -3, -2, -1)),
        Pair(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0)),
        Pair(intArrayOf(2, 2, 2, 1, 1), intArrayOf(1, 1, 2, 2, 2)),
        Pair(intArrayOf(1, 1, 0, 0, -1, -1), intArrayOf(-1, -1, 0, 0, 1, 1)),
        Pair(intArrayOf(-2, -1, 0, 1, 2, 3, 4, 5), intArrayOf(-2, -1, 0, 1, 2, 3, 4, 5)),
        Pair(intArrayOf(5, 5, 5, 5, 5, 5), intArrayOf(5, 5, 5, 5, 5, 5))

    )
    context("insertion") {
        withData(testSet) {
            insertionSort(it.first) shouldBe it.second
        }
    }
    context("bubble") {
        withData(testSet) {
            bubbleSort(it.first) shouldBe it.second
        }
    }
    context("selection") {
        withData(testSet) {
            selectionSort(it.first) shouldBe it.second
        }
    }
    context("merge") {
        withData(testSet) {
            mergeSort(it.first) shouldBe it.second
        }
    }
    context("count") {
        withData(testSet) {
            countSort(it.first) shouldBe it.second
        }
    }
})