import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PuzzleJavaTest {
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();

        List<Integer> sumArray = new ArrayList<>();
        Collections.addAll(sumArray, 3, 5, 1, 2, 7, 9, 8, 13, 25, 32);
        puzzle.sumValues(sumArray);

        List<String> shuffleArray = new ArrayList<>();
        Collections.addAll(shuffleArray, "Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa");
        puzzle.shuffleValues(shuffleArray);

        puzzle.alphaValues();

        puzzle.getRandom(55, 100);

        puzzle.sortRandom(55, 100);

        puzzle.randomString();

        puzzle.randomArray();
    }

}
