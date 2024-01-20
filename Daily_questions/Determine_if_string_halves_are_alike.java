public class Determine_if_string_halves_are_alike {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length/2; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i + length/2))) {
                count--;
            }
        }
        return count == 0 ? true : false;
    }
    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1 ? true : false;
    }
}
