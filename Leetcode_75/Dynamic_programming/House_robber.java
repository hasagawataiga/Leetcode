package Leetcode_75.Dynamic_programming;

public class House_robber {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1){
            return nums[0];
        }
        if (length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        return findMax(dp, nums, 2);
    }
    private int findMax(int[]dp , int[] nums, int index){
        if (index == nums.length){
            return dp[index - 1];
        }
        int ignorePosition = dp[index - 1];
        int takePosition = dp[index - 2];
        dp[index] = Math.max(ignorePosition, takePosition + nums[index]);
        return findMax(dp, nums, index + 1);
    }
}
