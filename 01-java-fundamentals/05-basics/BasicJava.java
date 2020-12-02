
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BasicJava {

    // Print 1-255
    public void printNums(int minNum, int maxNum) {

        for (int x = minNum; x <= maxNum; ++x) {
            System.out.println(x);
        }
    }

    // Print odd numbers between 1-255
    public void printOdd(int minNum, int maxNum) {

        for (int x = minNum; x <= maxNum; ++x) {
            int modOdd = x % 2;
            if (modOdd != 0) {
                System.out.println(x);
            }

        }
    }

    // Print Sum
    public void printSum(int minNum, int maxNum) {
        int sum = 0;
        for (int x = minNum; x <= maxNum; ++x) {
            sum += x;
            System.out.println("New number: " + x + " Sum: " + sum);
        }
    }

    // Iterating through an array
    public void iterateArray(int[] arr) {
        for (int x = 0; x < arr.length; ++x) {
            System.out.println(arr[x]);
        }
    }

    // Find Max
    public void findMax(List<Integer> arr) {
        int max = Collections.max(arr);
        System.out.println(max);
    }

    // Get Average
    public void getAverage(int[] arr) {
        int sum = 0;
        for (int x : arr)
            sum += x;
        int avg = sum / arr.length;
        System.out.println(avg);
    }

    // Array with Odd Numbers
    public void arrOdd(int minNum, int maxNum) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int x = minNum; x <= maxNum; ++x) {
            int modOdd = x % 2;
            if (modOdd != 0) {
                arr.add(x);
            }
        }
        for (int x : arr)
            System.out.println(x);
    }

    // Greater Than Y
    public void greaterThanY(int[] arr, int y) {
        int gt = 0;
        for (int x : arr) {
            if (x > y) {
                gt = gt + 1;
            }
        }
        System.out.println(gt);
    }

    // Square the values
    public void squareValues(List<Integer> arr) {
        int index = 0;
        for (int x : arr) {
            arr.set(index, x * x);
            index++;
        }
        System.out.println(arr);
    }

    // Eliminate Negative Numbers
    public void replaceNeg(List<Integer> arr) {
        int index = 0;
        for (int x : arr) {
            if (x < 0) {
                arr.set(index, 0);
            }
            index++;
        }
        System.out.println(arr);
    }

    // Max, Min, and Average
    public void getMaxMinAvg(List<Integer> arr) {
        int max = Collections.max(arr);
        int min = Collections.min(arr);

        double sum = 0;
        for (int x : arr)
            sum += x;
        double avg = sum / arr.size();

        List<Object> mmaArray = new ArrayList<>();
        mmaArray.add(max);
        mmaArray.add(min);
        mmaArray.add(avg);

        System.out.println(mmaArray);
    }

    // Shifting the Values in the Array
    public void shiftValues(List<Integer> arr) {
        arr.remove(0);
        arr.add(0);
        System.out.println(arr);
    }

}