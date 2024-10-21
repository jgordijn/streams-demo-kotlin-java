import split.data.LoremIpsum;

void main() {
    var result = splitLoop(LoremIpsum.TEXT);
    println(result);
}

String splitLoop(String line) {
     var pattern = Pattern.compile(" ");
     var words = pattern.split(line);
     for (var word : words) {
         if (word.length() > 3) {
             return word;
         }
     }
     throw new NoSuchElementException("No word longer than 3 characters found");
}