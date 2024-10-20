public class Minimum_division_operations_to_make_array_non_decreasing {
    class Solution {
        public int minOperations(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return 0;
            }
            int sumOperations = 0;
            for (int i = length - 2; i >= 0; i--) {
                int currVal = nums[i];
                while (currVal > nums[i + 1]) {
                    int gpd = findGPD(currVal);
                    int newVal = currVal / gpd;
                    if (newVal == currVal) {
                        return -1;
                    }
                    sumOperations++;
                    currVal = newVal;
                }
                nums[i] = currVal;
            }
            return sumOperations;
        }
    
        private int findGPD(int num) {
            if (num == 1) {return -1;}
            int gpd = 1;
            for (int i = num / 2; i > 1; i--) {
                if (num % i == 0) {
                    return i;
                }
            }
            return 1;
        }
    }
}
