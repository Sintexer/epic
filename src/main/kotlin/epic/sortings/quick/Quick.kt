package epic.sortings.quick

import java.io.PrintWriter
import java.util.*
import kotlin.random.Random

fun main() {
    _writer.solve(); _writer.flush()
}

fun PrintWriter.solve() {
    val array = readIntArray(readInt())
    val answer = quickSort(array, 0, array.size - 1).joinToString(" ")
    println(answer)
}

fun quickSort(nums: IntArray, leftIndex: Int, rightIndex: Int): IntArray {
    if (rightIndex - leftIndex < 1) {
        return nums
    }
    val pivot = nums[rightIndex]
    var l = leftIndex
    var r = rightIndex
    val temp = nums[rightIndex]
    nums[rightIndex] = nums[rightIndex]
    nums[rightIndex] = temp
    while (l < r) {
        while (nums[l] <= pivot && l < r) ++l
        while (nums[r] >= pivot && l < r) --r
        val temp1 = nums[l]
        nums[l] = nums[r]
        nums[r] = temp1
    }
    val temp1 = nums[l]
    nums[l] = nums[rightIndex]
    nums[rightIndex] = temp1
    val partitionIndex = l
    quickSort(nums, leftIndex, partitionIndex - 1)
    quickSort(nums, partitionIndex + 1, rightIndex)
    return nums
}

/** IO code start */
//@JvmField val INPUT = File("input.txt").inputStream()
//@JvmField val OUTPUT = File("output.txt").outputStream()
@JvmField
val INPUT = System.`in`

@JvmField
val OUTPUT = System.out

@JvmField
val _reader = INPUT.bufferedReader()

@JvmField
var _tokenizer: StringTokenizer = StringTokenizer("")
fun read(): String {
    while (_tokenizer.hasMoreTokens().not()) _tokenizer = StringTokenizer(_reader.readLine() ?: return "", " ")
    return _tokenizer.nextToken()
}

fun readInt() = read().toInt()
fun readIntArray(n: Int) = IntArray(n) { read().toInt() }

@JvmField
val _writer = PrintWriter(OUTPUT, false)

@JvmField
var _random: Random? = null
val random get() = _random ?: Random(0x14C285C321 * System.nanoTime()).also { _random = it }