public class StringManipulator {
    public String trimAndConcat(String first, String second) {
        String word = first.trim().concat(second.trim());
        return word;
    }

    public Integer getIndexOrNull(String word, char letter) {
        Integer indx = word.indexOf(letter);
        if (indx == -1) {
            indx = null;
        }
        return indx;
    }

    public Integer getIndexOrNull(String word, String sub) {
        Integer indx = word.indexOf(sub);
        if (indx == -1) {
            indx = null;
        }
        return indx;
    }

    public String concatSubstring(String word1, int num1, int num2, String word2) {
        String word = word1.substring(num1, num2).concat(word2);
        return word;
    }

}
