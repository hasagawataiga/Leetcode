package Daily_questions.Year_2025.May;

public class Type_of_triangle {
    class Solution {
        public String triangleType(int[] nums) {
            if (isNotValid(nums)) {
                return "none";
            }
            if (isEquilateral(nums)) {
                return "equilateral";
            }
            if (isIsosceles(nums)) {
                return "isosceles";
            }
            return "scalene";
        }

        private boolean isEquilateral(int[] nums) {
            return nums[0] == nums[1] && nums[1] == nums[2];
        }

        private boolean isIsosceles(int[] nums) {
            return nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2];
        }

        private boolean isNotValid(int[] nums) {
            return nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0];
        }
    }
}
