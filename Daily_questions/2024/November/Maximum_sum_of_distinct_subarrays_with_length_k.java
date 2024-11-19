public class Maximum_sum_of_distinct_subarrays_with_length_k {
    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            long max = 0;
            Set<Integer> existed = new HashSet<>();
            int left = 0;
            int right = 0;
            int length = nums.length;
            long currSum = 0;
            while (right < length) {
                currSum += nums[right];
                while (right - left >= k || existed.contains(nums[right])) {
                    existed.remove(nums[left]);
                    currSum -= nums[left++];
                }
                existed.add(nums[right]);
                if (right - left == k - 1) {
                    max = Math.max(max, currSum);
                }
                right++;
            }
            return max;
        }
    }
}