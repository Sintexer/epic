package epic.sortings

import epic.sortings.bubble.bubbleSort
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Bubble: StringSpec ({
    "should sort ascending" {
        val array = intArrayOf(1, 2, 3, 0)
        bubbleSort(array)
        array shouldBe intArrayOf(0, 1, 2, 3)
    }
    "should sort ascending 2" {
        val array = intArrayOf(4, 1, 2, 3, 0)
        bubbleSort(array)
        array shouldBe intArrayOf(0, 1, 2, 3, 4)
    }
    "should work" {
        val array = intArrayOf(0)
        bubbleSort(array)
        array shouldBe intArrayOf(0)
    }
    "with empty" {
        val array = intArrayOf()
        bubbleSort(array)
        array shouldBe intArrayOf()
    }
})