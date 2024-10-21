package splitkt


fun main() {
    val result = (0..3)
        .flatMap { i ->
            (0..3)
                .map { j -> Pair(i, j) }
        }
    println(result)
}