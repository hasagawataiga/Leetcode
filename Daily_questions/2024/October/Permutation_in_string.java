public class Permutation_in_string {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] chars1 = new int[26];
            for (char ch : s1.toCharArray()) {
                chars1[ch - 'a']++;
            }
            int total = s1.length();
            int left = 0;
            int right = 0;
            int length = s2.length();
            int[] chars2 = new int[26];
            while (right < length) {
                char curr = s2.charAt(right);
                chars2[curr - 'a']++;
                if (chars1[curr - 'a'] == chars2[curr - 'a']) {
                    if (isEqual(chars1, chars2)) {return true;}
                }
                while (left <= right && chars2[curr - 'a'] > chars1[curr - 'a']) {
                    chars2[s2.charAt(left) - 'a']--;
                    left++;
                }
                right++;
    
            }
            return false;
    
        }
    
        private boolean isEqual(int[] array1, int[] array2) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}