package Daily_questions.Year_2025.September;

import java.util.Arrays;

public class Largest_perimeter_triangle {
    class Solution {
        public int largestPerimeter(int[] nums) {
            int length = nums.length;
            Arrays.sort(nums);
            for (int i = nums.length - 1; i > 1; i--) {
                if (nums[i - 2] + nums[i - 1] > nums[i]) {
                    return nums[i - 2] + nums[i - 1] + nums[i];
                }
            }
            return 0;
        }
    }
}
