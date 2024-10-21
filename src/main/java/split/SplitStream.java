import split.data.LoremIpsum;

void main() {
    var result = splitStream(LoremIpsum.TEXT);
    println("result = " + result);
}

String splitStream(String line) {
    var pattern = Pattern.compile(" ");
    return pattern.splitAsStream(line)
            .filter(word -> word.length() > 3)
            .findFirst()
            .orElseThrow();
}