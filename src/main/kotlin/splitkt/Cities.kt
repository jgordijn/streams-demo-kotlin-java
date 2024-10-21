package splitkt

import java.util.*

data class Country(val name: String)
data class City(val name: String, val country: Country)

val cities = listOf(
    City("Paris", Country("France")),
    City("Nancy", Country("France")),
    City("London", Country("UK")),
    City("Berlin", Country("Germany")),
    City("Bonn", Country("Germany")),
    City("Frankfurt", Country("Germany")),
    City("Madrid", Country("Spain"))
)

val citiesSizeStream = cities.groupBy({ it.country }).mapValues { it.value.size }

val citiesSizeFold = cities.fold(mapOf<Country, Int>()) { acc, city ->
    acc + (city.country to (acc[city.country] ?: 0) + 1)
}

fun main() {
    assert(citiesSizeStream == citiesSizeFold)
    println(citiesSizeStream)

    val minCityCountry = citiesSizeFold.minByOrNull { it.value }!!

    println("Country with the fewest cities: $minCityCountry")

//    val x = mutableMapOf<Int, List<Country>>().toSortedMap()

    val allMinCities = citiesSizeStream.entries
        .groupBy({ it.value }) { it.key }
        .minByOrNull { it.key }!!

    val allMinCities2 = citiesSizeStream.entries
        .groupBy({ it.value })
        .minByOrNull { it.key }!!

    val minCitiesSizeFold = citiesSizeStream.entries.fold(emptyMap<Int, List<Country>>()) { acc, countryCount ->
        acc + (countryCount.value to ((acc.get(countryCount.value) ?: listOf(countryCount.key)) + countryCount.key ));
    }.toSortedMap().firstEntry().value


    println("input: ${citiesSizeStream.entries}")
    println("1Countries with the fewest cities: $allMinCities")
    println("2Countries with the fewest cities: $allMinCities2")
    println("Countries with the fewest cities: $minCitiesSizeFold")
}