package epic.sortings.count

import java.io.PrintWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.collections.sort as _sort
import kotlin.collections.sortDescending as _sortDescending
import kotlin.io.println as iprintln

fun main() {
    _writer.solve(); _writer.flush()
}

fun PrintWriter.solve() {
    val array = readIntArray(readInt())
    countSort(array)
    val answer = array.joinToString(" ")
    println(answer)
}

const val MAX_VALUE = 10_000

fun countSort(array: IntArray): IntArray {
    val counts = getCounts(array)
    var j = 0
    // go through negative values
    for (element in counts.size - 1 downTo MAX_VALUE + 1) {
        for (k in 0 until counts[element]) {
            array[j++] = -(element - MAX_VALUE)
        }
    }
    for (element in 0..MAX_VALUE) {
        for (k in 0 until counts[element]) {
            array[j++] = element
        }
    }
    return array
}

private fun getCounts(array: IntArray): List<Int> {
    val counts = MutableList(2 * MAX_VALUE + 1) { 0 }
    for (element in array) {
        val countIndex = getCountIndex(element)
        counts[countIndex]++
    }
    return counts
}

fun getCountIndex(element: Int): Int {
    return if (element >= 0) {
        element
    } else {
        -(element) + MAX_VALUE
    }
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
fun readLine(): String? = _reader.readLine()
fun readLn() = _reader.readLine()!!
@JvmField
var _tokenizer: StringTokenizer = StringTokenizer("")
fun read(): String {
    while (_tokenizer.hasMoreTokens().not()) _tokenizer = StringTokenizer(_reader.readLine() ?: return "", " ")
    return _tokenizer.nextToken()
}

fun readInt() = read().toInt()
fun readDouble() = read().toDouble()
fun readLong() = read().toLong()
fun readStrings(n: Int) = List(n) { read() }
fun readLines(n: Int) = List(n) { readLn() }
fun readInts(n: Int) = List(n) { read().toInt() }
fun readIntArray(n: Int) = IntArray(n) { read().toInt() }
fun readDoubles(n: Int) = List(n) { read().toDouble() }
fun readDoubleArray(n: Int) = DoubleArray(n) { read().toDouble() }
fun readLongs(n: Int) = List(n) { read().toLong() }
fun readLongArray(n: Int) = LongArray(n) { read().toLong() }

@JvmField
val _writer = PrintWriter(OUTPUT, false)

/** shuffles and sort overrides to avoid quicksort attacks */
private inline fun <T> _shuffle(rnd: Random, get: (Int) -> T, set: (Int, T) -> Unit, size: Int) {
    // Fisher-Yates shuffle algorithm
    for (i in size - 1 downTo 1) {
        val j = rnd.nextInt(i + 1)
        val temp = get(i)
        set(i, get(j))
        set(j, temp)
    }
}

@JvmField
var _random: Random? = null
val random get() = _random ?: Random(0x14C285C321 * System.nanoTime()).also { _random = it }

fun IntArray.shuffle(rnd: Random = random) = _shuffle(rnd, ::get, ::set, size)
fun IntArray.sort() {
    shuffle(); _sort()
}

fun IntArray.sortDescending() {
    shuffle(); _sortDescending()
}

fun LongArray.shuffle(rnd: Random = random) = _shuffle(rnd, ::get, ::set, size)
fun LongArray.sort() {
    shuffle(); _sort()
}

fun LongArray.sortDescending() {
    shuffle(); _sortDescending()
}

fun DoubleArray.shuffle(rnd: Random = random) = _shuffle(rnd, ::get, ::set, size)
fun DoubleArray.sort() {
    shuffle(); _sort()
}

fun DoubleArray.sortDescending() {
    shuffle(); _sortDescending()
}

fun CharArray.shuffle(rnd: Random = random) = _shuffle(rnd, ::get, ::set, size)
inline fun CharArray.sort() {
    _sort()
}

inline fun CharArray.sortDescending() {
    _sortDescending()
}

inline fun <T : Comparable<T>> Array<out T>.sort() = _sort()
inline fun <T : Comparable<T>> Array<out T>.sortDescending() = _sortDescending()
inline fun <T : Comparable<T>> MutableList<out T>.sort() = _sort()
inline fun <T : Comparable<T>> MutableList<out T>.sortDescending() = _sortDescending()

fun `please stop removing these imports IntelliJ`() {
    iprintln(1)
}