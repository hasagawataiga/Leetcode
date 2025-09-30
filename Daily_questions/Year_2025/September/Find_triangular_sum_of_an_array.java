package Daily_questions.Year_2025.September;

class Find_triangular_sum_of_an_array {
    class Solution {
        public int triangularSum(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            for (int i = length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    nums[j] = (nums[j] + nums[j + 1]) % 10;
                }
            }
        
            return nums[0];
        }
    }
}