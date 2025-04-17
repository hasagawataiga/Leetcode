public class Count_equal_and_divisible_pairs_in_an_array {
    class Solution {
        public int countPairs(int[] nums, int k) {
            int count = 0;
    
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] != nums[j]) {
                        continue;
                    }
                    if (i * j % k == 0) {
                        count++;
                    }
                }
            }
    
            return count;   
        }
    }
}
