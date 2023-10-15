package epic.sortings.insertion

import io.kotest.core.spec.style.StringSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class InsertionKtTest: StringSpec ({
    withData(
        Pair(intArrayOf(1), intArrayOf(1)),
        Pair(intArrayOf(0), intArrayOf(0)),
        Pair(intArrayOf(), intArrayOf()),
        Pair(intArrayOf(0, 2, 4, 6, 8), intArrayOf(0, 2, 4, 6, 8)),
        Pair(intArrayOf(4, 2, 5, 1, 9, 2), intArrayOf(1, 2, 2, 4, 5, 9)),
        Pair(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),
        Pair(intArrayOf(1, 2, 3, 4, 0), intArrayOf(0, 1, 2, 3, 4)),
        Pair(intArrayOf(1, -2, 3, -4, 0), intArrayOf(-4, -2, 0, 1, 3))
    ) {
        val sorted = insertionSort(it.first)
        sorted shouldBe it.second
    }
})