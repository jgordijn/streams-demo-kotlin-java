package splitkt

import split.data.LoremIpsum

fun main() {
    val result = splitStream(LoremIpsum.TEXT)
    println(result)
}

fun splitStream(line: String): String =
    line.split(" ")
        .first { it.length > 3 } // orElseThrow() is implicit
