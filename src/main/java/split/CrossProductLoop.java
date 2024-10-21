import kotlin.Pair;

void main() {
    var resultLoop = new ArrayList<Pair>();
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            resultLoop.add(new Pair(i, j));
        }
    }
    println(resultLoop);
}