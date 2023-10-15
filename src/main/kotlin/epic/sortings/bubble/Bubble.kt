package epic.sortings.bubble

import java.io.PrintWriter
import java.util.*

@JvmField
val INPUT = System.`in`
@JvmField
val OUTPUT = System.out

@JvmField
val _reader = epic.sortings.insertion.INPUT.bufferedReader()
fun readLine(): String? = epic.sortings.insertion._reader.readLine()
fun readLn() = epic.sortings.insertion._reader.readLine()!!
@JvmField
var _tokenizer: StringTokenizer = StringTokenizer("")
fun read(): String {
    while (epic.sortings.insertion._tokenizer.hasMoreTokens().not()) epic.sortings.insertion._tokenizer = StringTokenizer(
        epic.sortings.insertion._reader.readLine() ?: return "", " ")
    return epic.sortings.insertion._tokenizer.nextToken()
}

fun readInt() = epic.sortings.insertion.read().toInt()
fun readDouble() = epic.sortings.insertion.read().toDouble()
fun readLong() = epic.sortings.insertion.read().toLong()
fun readStrings(n: Int) = List(n) { epic.sortings.insertion.read() }
fun readLines(n: Int) = List(n) { epic.sortings.insertion.readLn() }
fun readInts(n: Int) = List(n) { epic.sortings.insertion.read().toInt() }
fun readIntArray(n: Int) = IntArray(n) { epic.sortings.insertion.read().toInt() }
fun readDoubles(n: Int) = List(n) { epic.sortings.insertion.read().toDouble() }
fun readDoubleArray(n: Int) = DoubleArray(n) { epic.sortings.insertion.read().toDouble() }
fun readLongs(n: Int) = List(n) { epic.sortings.insertion.read().toLong() }
fun readLongArray(n: Int) = LongArray(n) { epic.sortings.insertion.read().toLong() }

@JvmField
val _writer = PrintWriter(epic.sortings.insertion.OUTPUT, false)
inline fun output(block: PrintWriter.() -> Unit) {
    epic.sortings.insertion._writer.apply(block).flush()
}

fun main() {
    val array = epic.sortings.insertion.readIntArray(epic.sortings.insertion.readInt())
    output {
        bubbleSort(array)
        println(array.joinToString(" "))
    }
}

fun bubbleSort(array: IntArray) {
    for (lastUnsorted in array.size - 1 downTo 1) {
        for (i in 0 until lastUnsorted) {
            if (array[i] > array[i + 1]) {
                val temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
            }
        }
    }
}

