package epic.searches

import epic.searches.binary.binarySearch
import epic.searches.cows.cowsLeastMaxDistance
import epic.searches.easy.easiestSolution
import io.kotest.core.Tuple3
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

/*
1 2 3 4 5 6 7 8 9 10
10 9 8 7 6 5 4 3 2 1
5 10 3 8 1 6 9 2 7 4
3 7 2 9 4 8 1 6 10 5 11
6 1 8 3 10 5 12 7 14 2 9 4
9 4 11 6 13 1 8 3 10 5 12 7 14
2 7 12 17 22 27 32 37 42 47 52 57 62 67
15 30 45 60 75 90 105 120 135 150 165 180 195 210 225
20 40 60 80 100 120 140 160 180 200 220 240 260 280 300 320
25 50 75 100 125 150 175 200 225 250 275 300 325 350 375 400 425
30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540
 */

class InsertionKtTest: FunSpec({

    val positiveCases = listOf(
        Pair("1 2 3 4 5 6 7 8 9 10", 3),
        Pair("1 2 3 4 5 6 7 8 9 10", 10),
        Pair("1 2 3 4 5 6 7 8 9 10", 1),
        Pair("1 2 3 4 5 6 7 8 9 10", 8),
        Pair("-10 -9 -8 -7 -6 -5 -4 -3 -2 1", -3),
        Pair("-10 -9 -8 -7 -6 -5 -4 -3 -2 1", -7),
        Pair("-10 -9 -8 -7 -6 -5 -4 -3 -2 1", -10),
        Pair("-10 -9 -8 -7 -6 -5 -4 -3 -2 1", 1),
        Pair("15 30 45 60 75 90 105 120 135 150 165 180 195 210 225", 105),
        Pair("15 30 45 60 75 90 105 120 135 150 165 180 195 210 225", 225),
        Pair("15 30 45 60 75 90 105 120 135 150 165 180 195 210 225", 15),
        Pair("15 30 45 60 75 90 105 120 135 150 165 180 195 210 225", 45),
        Pair("30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540", 30),
        Pair("30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540", 240),
        Pair("30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540", 270),
        Pair("30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540", 300),
        Pair("30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540", 390),
        Pair("30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540", 540),
    )

    val negativeCases = listOf(
        Pair("1 2 3 4 5 6 7 8 9 10", -3),
        Pair("1 2 3 4 5 6 7 8 9 10", 1000),
        Pair("-10 -9 -8 -7 -6 -5 -4 -3 -2 1", -1),
        Pair("15 30 45 60 75 90 105 120 135 150 165 180 195 210 225", 0),
        Pair("30 60 90 120 150 180 210 240 270 300 330 360 390 420 450 480 510 540", 1000),
    )

    context("binarySearch") {
        withData(positiveCases) {
            val array = toArray(it)
            binarySearch(array, it.second) shouldBe array.binarySearch(it.second)
        }
        withData(negativeCases) {
            val array = toArray(it)
            binarySearch(array, it.second) shouldBe -1
        }
    }

    context("easiestSolution") {
        withData(listOf(
            Tuple3(4, 1, 1),
            Tuple3(5, 1, 2),
            Tuple3(512, 1, 2),
            Tuple3(63, 9, 8),
            Tuple3(2000, 8, 5),
            Tuple3(616, 1, 9),
            Tuple3(Integer.MAX_VALUE, 1, 2),
            Tuple3(1, 10, 10),
            Tuple3(2, 10, 10),
            Tuple3(3, 10, 10),
        )) {
            easiestSolution(it.a, it.b, it.c) shouldBe easiestSolution(it.a, it.b, it.c)
//            easiestSolution(it.a, it.b, it.c) shouldBe validationSolution(it.a, it.b, it.c)
        }
    }

    context("cows") {
        withData(listOf(
            Tuple3(3, "2 5 7 11 15 20", 9L),
            Tuple3(3, "1 2 3 100 1000", 99L),
        )) {
            cowsLeastMaxDistance(it.a, it.b.toLongArray()) shouldBe it.c
        }
    }


})

private fun toArray(it: Pair<String, Int>) = it.first.split(" ").map { it.toInt() }.toIntArray()
private fun String.toLongArray() = this.split(" ").map { it.toLong() }.toLongArray()