public class Count_the_number_of_consistent_strings {
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int res = words.length;
            boolean[] chars = new boolean[26];
            for (char ch : allowed.toCharArray()) {
                chars[ch - 'a'] = true;
            }
            for (String word : words) {
                for (char ch : word.toCharArray()) {
                    if (!chars[ch - 'a']) {
                        res--;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
