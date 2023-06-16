package Leetcode_75.Sliding_window_two_pointer;

public class Longest_subarray_of_1s_after_deleting_one_element {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        boolean hasZero = false;
        int count = 0;
        while (right < n){
            if (nums[right] == 0 && hasZero){
                while (nums[left] != 0){
                    left++;
                }
                left++;
            } else if (nums[right] == 0 && !hasZero){
                hasZero = true;
            }
            right++;
            count = Math.max(count, right - left);
        }
        return count == 0 ? 0 : count - 1;
    }
}
