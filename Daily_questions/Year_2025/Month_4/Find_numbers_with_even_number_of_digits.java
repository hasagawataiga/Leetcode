public class Find_numbers_with_even_number_of_digits {
    class Solution {
        public int findNumbers(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (countNumberOfDigits(nums[i]) % 2 == 0) {
                    count++;
                }
            }
    
            return count;
        }
    
        private int countNumberOfDigits(int num) {
            int count = 0;
    
            while (num != 0) {
                count++;
                num /= 10;
            }
            return count;
        }
    }
}
