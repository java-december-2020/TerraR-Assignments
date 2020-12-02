import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleJava {

    // Sum All Numbers
    public void sumValues(List<Integer> arr) {
        int sum = 0;
        List<Object> gtArray = new ArrayList<>();

        for (Integer x : arr) {
            sum += x;
            if (x > 10) {
                gtArray.add(x);
            }
        }
        System.out.println(sum);
        System.out.println(gtArray);
    }

    // Shuffle Values in an Array
    public void shuffleValues(List<String> arr) {
        List<String> gt5Array = new ArrayList<>();
        Collections.shuffle(arr);
        for (String x : arr) {
            if (x.length() > 5) {
                gt5Array.add(x);
            }
        }
        System.out.println(arr);
        System.out.println(gt5Array);
    }

    // Shuffle alphabets in an Array
    public void alphaValues() {
        ArrayList<Character> alphabet = new ArrayList<>();

        ArrayList<Character> vowel = new ArrayList<>();
        Collections.addAll(vowel, 'a', 'e', 'i', 'o', 'u');

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        System.out.println("Last letter: " + alphabet.get(alphabet.size() - 1));
        System.out.println("First letter: " + alphabet.get(0));

        for (char x : vowel) {
            if (x == alphabet.get(0)) {
                System.out.println("First letter is a vowel.");
                break;
            }
        }
    }

    // Generate random numbers
    public void getRandom(int minNum, int maxNum) {
        ArrayList<Integer> nums = new ArrayList<>(10);
        Random randomNum = new Random();

        while (nums.size() < 10) {
            int rand = randomNum.nextInt(maxNum);
            if (rand >= minNum & rand <= maxNum) {
                nums.add(rand);
            }
        }
        System.out.println(nums);
    }

    // Generate and sort random numbers
    public void sortRandom(int minNum, int maxNum) {
        ArrayList<Integer> nums = new ArrayList<>(10);
        Random randomNum = new Random();

        while (nums.size() < 10) {
            int rand = randomNum.nextInt(maxNum);
            if (rand >= minNum & rand <= maxNum) {
                nums.add(rand);
            }
        }
        Collections.sort(nums);
        System.out.println(nums);

        int max = Collections.max(nums);
        int min = Collections.min(nums);
        System.out.println("The max is: " + max);
        System.out.println("The min is: " + min);
    }

    // Generate random string
    public void randomString() {
        ArrayList<Character> alphabet = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }
        String fiveChar = "";
        int i = 0;
        while (i < 5) {
            Collections.shuffle(alphabet);
            Character getFirst = alphabet.get(0);
            String addString = Character.toString(getFirst);

            fiveChar = fiveChar.concat(addString);
            ++i;
        }
        System.out.println(fiveChar);
    }

    // Generate random array
    public void randomArray() {
        ArrayList<Character> alphabet = new ArrayList<>();
        ArrayList<String> word = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }

        while (word.size() < 10) {

            String fiveChar = "";
            int i = 0;
            while (i < 5) {
                Collections.shuffle(alphabet);
                Character getFirst = alphabet.get(0);
                String addString = Character.toString(getFirst);
                fiveChar = fiveChar.concat(addString);
                ++i;
            }
            word.add(fiveChar);
        }

        System.out.println(word);
    }

}