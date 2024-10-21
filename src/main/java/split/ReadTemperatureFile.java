package split;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadTemperatureFile {
    static List<Float> readLoop(Path file) throws IOException {
        try (var reader = Files.newBufferedReader(file)) {
            var floats = new ArrayList<Float>();
            var line = reader.readLine();
            while (line != null) {
                if (!line.startsWith("#")) {
                    try {
                        var f = Float.parseFloat(line);
                        floats.add(f);
                    } catch (NumberFormatException _) {
                        // Ignoring invalid float lines
                    }
                }
                line = reader.readLine();
            }
            return Collections.unmodifiableList(floats);
        }
    }


    static List<Float> readStreamV1(Path file) throws IOException {
        try (var lines = Files.lines(file)) {
            return lines
                    .filter(line -> !line.startsWith("#"))
                    .filter(line -> {
                        try {
                            var f = Float.parseFloat(line);
                            return true;
                        } catch (NumberFormatException _) {
                            return false;
                        }
                    })
                    .map(Float::parseFloat)
                    .toList();
        }
    }

    static List<Float> readStreamV2(Path file) throws IOException {
        try (var lines = Files.lines(file)) {
            return lines
                    .filter(line -> !line.startsWith("#"))
                    .<Float>mapMulti((line, downstream) -> {
                        try {
                            var f = Float.parseFloat(line);
                            downstream.accept(f);
                        } catch (NumberFormatException _) {
                            // Ignoring invalid float lines
                        }
                    })
                    .toList();
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        // Read the inputTemps.txt file from the classpath
        var url = ReadTemperatureFile.class.getClassLoader().getResource("inputTemps.txt");
        Path file = Paths.get(url.toURI());

        var floats = readLoop(file);
        System.out.println("floats = " + floats);


        var floats2 = readStreamV1(file);
        System.out.println("floats2 = " + floats2);

        var floats3 = readStreamV2(file);
        System.out.println("floats3 = " + floats3);
    }

}
