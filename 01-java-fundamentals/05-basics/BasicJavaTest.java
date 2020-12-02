import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BasicJavaTest {
    public static void main(String[] args) {
        BasicJava basic = new BasicJava();

        basic.printNums(1, 255);

        basic.printOdd(1, 255);

        basic.printSum(0, 255);

        int[] iterate = { 1, 3, 5, 7, 9, 13 };
        basic.iterateArray(iterate);

        List<Integer> maxArray = new ArrayList<>();
        Collections.addAll(maxArray, -3, -5, -7);
        basic.findMax(maxArray);

        int[] avgArray = { 2, 10, 3 };
        basic.getAverage(avgArray);

        basic.arrOdd(1, 255);

        int[] gtArray = { 1, 3, 5, 7 };
        basic.greaterThanY(gtArray, 3);

        List<Integer> sqArray = new ArrayList<>();
        Collections.addAll(sqArray, 1, 5, 10, -2);
        basic.squareValues(sqArray);

        List<Integer> negArray = new ArrayList<>();
        Collections.addAll(negArray, 1, 5, 10, -2);
        basic.replaceNeg(negArray);

        List<Integer> mmaArray = new ArrayList<>();
        Collections.addAll(mmaArray, 1, 5, 10, -2);
        basic.getMaxMinAvg(mmaArray);

        List<Integer> shiftArray = new ArrayList<>();
        Collections.addAll(shiftArray, 1, 5, 10, 7, -2);
        basic.shiftValues(shiftArray);

    }
}
