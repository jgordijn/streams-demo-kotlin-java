package split;

import java.util.Map;

class MinCitiesStream {
    public static void main(String[] args) {
        var result = CitiesStream.getCountryLongMap().entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow();
        System.out.println("result = " + result);
    }
}