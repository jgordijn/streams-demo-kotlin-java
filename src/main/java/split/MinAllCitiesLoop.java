package split;

import split.data.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MinAllCitiesLoop {
    public static void main(String[] args) {
        var map = new TreeMap<Long, List<Country>>();
        for (var countryCount : CitiesStream.getCountryLongMap().entrySet()) {
            // This initial value must be a mutable List, because we add data to it later.
            map.computeIfAbsent(countryCount.getValue(), _ -> new ArrayList<>()).add(countryCount.getKey());
        }
        System.out.println("result = " + map.firstEntry());
    }
}