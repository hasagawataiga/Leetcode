package Leetcode_75.Sliding_window_two_pointer;

public class Max_consecutive_ones_iii {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroes = k;
        int n = nums.length;
        int max = 0;
        while (right < n){
            if (nums[right] == 0 && zeroes == 0){
                if (nums[left] == 0){
                    left++;
                } else {
                    while (nums[left] != 0){
                        left++;
                    }
                    left++;
                }
            } else if (nums[right] == 0 && zeroes > 0){
                zeroes--;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
