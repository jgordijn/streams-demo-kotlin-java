package split;

import org.jetbrains.annotations.NotNull;
import split.data.Cities;
import split.data.City;
import split.data.Country;

import module java.base;

class CitiesStream {
    public static void main(String[] args) {

        Map<Country, Long> cityCountPerCountry = getCountryLongMap();

        System.out.println(cityCountPerCountry);
    }

    @NotNull
    public static Map<Country, Long> getCountryLongMap() {
        Map<Country, Long> cityCountPerCountry =
                Cities.cities.stream()
                        .collect(
                                Collectors.groupingBy(
                                        City::country,
                                        Collectors.counting()
                                )
                        );
        return cityCountPerCountry;
    }
}