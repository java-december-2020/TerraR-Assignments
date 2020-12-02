public class Pythagorean {
    public String calculateHypotenuse(int legA, int legB) {
        double result = Math.sqrt((legA * legA) + (legB * legB));
        return "The hypotenuse is: " + result;
    }
}
