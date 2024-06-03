public class Append_characters_to_string_to_make_subsequence {
    public int appendCharacters(String s, String t) {
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < s.length()) {
            if (secondPointer == t.length()) {
                return 0;
            }
            if (s.charAt(firstPointer) == t.charAt(secondPointer)) {
                secondPointer++;
            }
            firstPointer++;
        }
        return t.length() - secondPointer;
    }
}