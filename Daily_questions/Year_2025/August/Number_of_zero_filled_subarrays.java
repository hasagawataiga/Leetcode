public class Number_of_zero_filled_subarrays {
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            int index = 0;
            long res = 0;
            long countZeroes = 0;
            while (index < nums.length) {
                if (nums[index] == 0) {
                    countZeroes++;
                } else {
                    res += calculateSubarray(countZeroes);
                    countZeroes = 0;
                }
                index++;
            }

            if (countZeroes != 0) {
                res += calculateSubarray(countZeroes);
            }
            return res;
        }

        private long calculateSubarray(long n) {
            return (long)(n * (n + 1) / 2);
        }
    }
}
