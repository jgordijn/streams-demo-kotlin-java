import kotlin.Pair;

void main() {
    var resultStream = IntStream.range(0, 4)
            .boxed()
            .flatMap(a -> IntStream.range(0, 4)
                    .mapToObj(b -> new Pair(a, b)))
            .toList();
    println(resultStream);
}
