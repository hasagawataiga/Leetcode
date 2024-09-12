public class Count_the_number_of_consistent_strings {
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int res = words.length;
            for (String word : words) {
                for (char ch : word.toCharArray()) {
                    if (!allowed.contains(ch + "")) {
                        res--;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
