package interview_questions.dynamic_programming;

public class House_robber {
    public int rob(int[] nums) {
        if (nums == null){
            return 0;
        }
        int length = nums.length;
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        // At index 1 in dp array, two posible ways to follow:
        //  take nums[1] or take nums[0] (ignore nums[1])
        //  which ways is greater is selected
        dp[1] = Math.max(nums[0], nums[1]);
        return findMax(nums, dp, 2);
    }
    private int findMax (int[] nums, int[] dp, int index){
        // The recursion would be stopped when index == length
        //  then the properly index of dp should be dp[index-1]
        //  instead of index
        if (index == nums.length){
            return dp[index - 1];
        }
        // As explaination above, there are two ways to consider:
        //  -pick the value at the index and the value of (index - 2)
        //  -ignore it and pick the value of (index - 1)
        //  compare those and pick the greater one for dp[index]
        int takeThePosition = nums[index] + dp[index - 2];
        int ignoreThePosition = dp[index - 1];
        int max = Math.max(takeThePosition, ignoreThePosition);
        dp[index++] = max;
        return findMax(nums, dp, index);
    }
}
