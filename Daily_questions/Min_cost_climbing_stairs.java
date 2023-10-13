
public class Min_cost_climbing_stairs{
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        dp(cost, dp, cost.length);
        return dp[cost.length];
    }
    private void dp(int[] cost, int[] dp, int index) {
        if (dp[index] != -1){
            return;
        }
        if (index == 0 || index == 1){
            dp[index] = 0;
            return;
        }
        dp(cost, dp, index - 1);
        dp(cost, dp, index - 2);
        dp[index] = Math.min(dp[index - 1] + cost[index - 1], dp[index - 2] + cost[index - 2]);
    }
}