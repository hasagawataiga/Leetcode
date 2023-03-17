package Leetcode_75.Prefix_sum;

public class Running_sum_of_1d_array {
    public int[] runningSum(int[] nums) {
        if (nums.length < 1){
            return null;
        }
        for (int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
