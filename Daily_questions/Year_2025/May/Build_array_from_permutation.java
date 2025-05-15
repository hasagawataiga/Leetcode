package Daily_questions.Year_2025.May;

public class Build_array_from_permutation {
    class Solution {
        public int[] buildArray(int[] nums) {
            int[] ans = new int[nums.length];
    
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[nums[i]];
            }
            return ans;
        }
    }
}
