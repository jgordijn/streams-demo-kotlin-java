package split;

import java.util.Collections;
import java.util.Map;

public class MinCitiesCollection {
    public static void main(String[] args) {
        var result = Collections.min(CitiesStream.getCountryLongMap().entrySet(), Map.Entry.comparingByValue());
        System.out.println("result = " + result);
    }
}
