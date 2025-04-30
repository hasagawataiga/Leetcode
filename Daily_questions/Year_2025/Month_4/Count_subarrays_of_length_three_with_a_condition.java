public class Count_subarrays_of_length_three_with_a_condition {
    class Solution {
        public int countSubarrays(int[] nums) {
            int count = 0;
            int left = 0;
            int right = 2;
    
            while (right < nums.length) {
                if (right - left == 3) {
                    left++;
                }
                if (isValid(nums, left, right)) {
                    count++;
                }
                right++;
            }
    
            return count;
        }
    
        private boolean isValid(int[] arr, int start, int end) {
            return (arr[start] + arr[end]) * 2 == arr[end - 1];
        }
    }
}
