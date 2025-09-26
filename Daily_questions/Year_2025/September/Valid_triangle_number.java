package Daily_questions.Year_2025.September;

import java.util.Arrays;

public class Valid_triangle_number {
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int count = 0;
            int length = nums.length;

            for (int i = length - 1; i > 1; i--) {
                int firstPointer = 0;
                int secondPointer = i - 1;
                while (secondPointer > firstPointer) {
                    if (isTriangle(nums[firstPointer], nums[secondPointer], nums[i])) {
                        count += secondPointer - firstPointer;
                        secondPointer--;
                    } else {
                        firstPointer++;
                    }
                }
            }

            return count;
        }

        private boolean isTriangle(int a, int b, int c) {
            return a + b > c ? true : false;
        }
    }
}
