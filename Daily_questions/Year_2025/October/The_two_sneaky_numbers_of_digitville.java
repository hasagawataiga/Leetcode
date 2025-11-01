public class The_two_sneaky_numbers_of_digitville {
    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            int[] container = new int[101];
            int[] res = new int[2];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (container[nums[i]] != 0) {
                    res[index++] = nums[i];
                }
                container[nums[i]]++;
            }

            return res;
        }
    }
}