void main() {

    List<Integer> ints = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
        ints.add(i);
    }
    var intsFromLoop = Collections.unmodifiableList(ints);



    var intsFromStream = IntStream.range(0, 100).boxed().toList();
}