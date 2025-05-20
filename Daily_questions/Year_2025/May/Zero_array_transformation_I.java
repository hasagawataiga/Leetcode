package Daily_questions.Year_2025.May;

public class Zero_array_transformation_I {
    class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int[] countedArray = new int[nums.length + 1];
            for (int i = 0; i < queries.length; i++) {
                int start = queries[i][0];
                int end = queries[i][1];
                countedArray[start]++;
                countedArray[end + 1]--;
            }

            int prefix = 0;
            for (int i = 0; i < nums.length; i++) {
                prefix += countedArray[i];
                if (nums[i] > prefix) {
                    return false;
                }
            }

            return true;
        }
    }
}
