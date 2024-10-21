package splitkt

import split.ReadTemperatureFile
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.useLines

fun main() {
    // Read the file on my classpath name inputTemps.txt

    // Read the inputTemps.txt file from the classpath
    val url = ReadTemperatureFile::class.java.classLoader.getResource("inputTemps.txt")
    val file = Paths.get(url.toURI())
    val result = readStreamKt(file)
    println("Temperatures: $result")
}

fun readStreamKt(file: Path): List<Float> =
    file.useLines { lines ->
        lines
            .filterNot { it.startsWith("#") }
            .mapNotNull { it.toFloatOrNull() }
    }
            .toList()
