package split;

import org.jetbrains.annotations.NotNull;
import split.data.Cities;
import split.data.Country;

import java.util.HashMap;
import java.util.Map;

class CitiesLoop {
    void main() {
        Map<Country, Long> cityCountPerCountry = getCountryLongMap();
        System.out.println(cityCountPerCountry);
    }

    @NotNull
    public static Map<Country, Long> getCountryLongMap() {
        Map<Country, Long> cityCountPerCountry = new HashMap<>();
        for (var city : Cities.cities) {
            cityCountPerCountry.merge(city.country(), 1L, Long::sum);
        }
        return cityCountPerCountry;
    }
}