import split.data.LoremIpsum;

void main() {
    var result = splitLoop(LoremIpsum.TEXT);
    println(result);
}

record IndexWord(int index, String value) { }

IndexWord splitLoop(String line) {
    var pattern = Pattern.compile(" ");
    var words = pattern.split(line);
    for (int index = 0; index < words.length; index++) {
        if (words[index].length() == 3) {
            return new IndexWord(index, words[index]);
        }
    }
    throw new NoSuchElementException("Not found");
}