package split;

import split.data.City;
import split.data.Country;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MinAllCitiesStream {
    public static void main(String[] args) {
        TreeMap<Long, List<Country>> countriesCountPerCity =
                CitiesStream.getCountryLongMap().entrySet()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Map.Entry::getValue,
                                        TreeMap::new,
                                        Collectors.mapping(
                                                Map.Entry::getKey,
                                                Collectors.toList()
                                        )
                                )
                        );
        var result = countriesCountPerCity.firstEntry();
        System.out.println("countriesCountPerCity = " + countriesCountPerCity.firstEntry());
    }
}
