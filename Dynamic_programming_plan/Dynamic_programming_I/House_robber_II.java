package Dynamic_programming_plan.Dynamic_programming_I;


// Use the same algorithm as problem "House Robber"
// Hint: check 2 range (0 -> length - 2) and (1 -> length - 1)
// Compare those and return the greater one
public class House_robber_II {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1){
            return nums[0];
        }
        if (length == 2){
            return Math.max(nums[0], nums[1]);
        }
        if (length == 3){
            return Math.max(Math.max(nums[1], nums[0]), nums[2]);
        }
        int[] dp1 = new int[length];
        int[] dp2 = new int[length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0], nums[1]);
        dp2[1] = nums[1];
        // Math.max(nums[1], nums[2]);
        dp2[2] = Math.max(dp2[1], nums[2]);
        int max1 = findMax(dp1, nums, 2, length - 2);
        int max2 = findMax(dp2, nums, 3, length - 1);
        return Math.max(max1, max2);
    }
    private int findMax(int[] dp, int[] nums, int index, int n){
        if (index >= n + 1){
            return dp[index - 1];
        }
        int ignorePosition = dp[index - 1];
        int takePosition = dp[index - 2] + nums[index];
        dp[index] = Math.max(ignorePosition, takePosition);
        return findMax(dp, nums, index + 1, n);
    }
}
