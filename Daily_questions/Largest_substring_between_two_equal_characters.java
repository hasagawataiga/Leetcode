import java.util.Arrays;

public class Largest_substring_between_two_equal_characters {
        public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        int[] container = new int[26];
        Arrays.fill(container, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (container[ch - 'a'] != -1) {
                max = Math.max(max, i - container[ch - 'a'] - 1);
            } else {
                container[ch - 'a'] = i;
            }
        }
        return max;
    }
}
