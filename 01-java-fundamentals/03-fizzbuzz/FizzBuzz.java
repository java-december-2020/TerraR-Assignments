public class FizzBuzz {
    public String fizzBuzz(int number) {
        String result;
        int mod3 = number % 3;
        int mod5 = number % 5;

        if (mod3 == 0 & mod5 == 0) {
            result = "FizzBuzz";
        } else if (mod3 == 0) {
            result = "Fizz";
        } else if (mod5 == 0) {
            result = "Buzz";
        } else {
            result = Integer.toString(number);
        }
        return result;
    }
}
