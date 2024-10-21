import split.data.LoremIpsum;

void main() {
    var result = splitLoop(LoremIpsum.TEXT);
    println(result);
}

record IndexWord(int index, String value) {
}

IndexWord splitLoop(String line) {
    var pattern = Pattern.compile(" ");
    var words = pattern.split(line);
    return IntStream.range(0, words.length)
            .filter(index -> words[index].length() == 3)
            .mapToObj(index -> new IndexWord(index, words[index]))
            .findFirst()
            .orElseThrow();
}