public class Maximum_difference_between_increasing_elements {
    class Solution {
        public int maximumDifference(int[] nums) {
            int min = nums[0];
            int maxDiff = -1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= min) {
                    min = Math.min(min, nums[i]);
                    continue;
                }
                maxDiff = Math.max(maxDiff, nums[i] - min);
                min = Math.min(min, nums[i]);
            }

            return maxDiff;
        }
    }
}