package splitkt

import split.data.LoremIpsum

fun main() {
    val result = splitIndexStream(LoremIpsum.TEXT)
    println(result)
}

data class IndexWord(val index: Int, val value: String)

fun splitIndexStream(line: String): IndexWord =
    line.split(" ")
        .withIndex()
        .map { (index, value) -> IndexWord(index, value) }
        .first { it.value.length == 3 }
