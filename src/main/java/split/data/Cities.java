package split.data;

import java.util.List;

public class Cities {
    public static List<City> cities = List.of(
            new City("Paris", new Country("France")),
            new City("Paris", new Country("France")),
            new City("Nancy", new Country("France")),
            new City("London", new Country("UK")),
            new City("Berlin", new Country("Germany")),
            new City("Bonn", new Country("Germany")),
            new City("Frankfurt", new Country("Germany")),
            new City("Madrid", new Country("Spain"))
    );

}
