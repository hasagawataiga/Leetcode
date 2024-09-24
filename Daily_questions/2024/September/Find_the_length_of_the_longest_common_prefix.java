public class Find_the_length_of_the_common_prefix {
    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Set<String> prefixs = new HashSet<>();
            for (int i = 0; i < arr1.length; i++) {
                while (arr1[i] != 0) {
                    prefixs.add(String.valueOf(arr1[i]));
                    arr1[i] /= 10;
                }
            }
            int max = 0;
            for (int i = 0; i < arr2.length; i++) {
                String curr = String.valueOf(arr2[i]);
                int length = curr.length();
                while (length > max) {
                    if (prefixs.contains(curr.substring(0, length))) {
                        max = Math.max(max, length);
                    }
                    length--;
                }
            }
            return max;
        }
    }
}