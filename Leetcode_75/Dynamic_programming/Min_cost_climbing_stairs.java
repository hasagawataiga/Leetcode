package Leetcode_75.Dynamic_programming;

public class Min_cost_climbing_stairs {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] mins = new int[length];
        mins[0] = cost[0];
        mins[1] = cost[1];
        for (int i = 2; i < length; i++){
            mins[i] = Math.min(mins[i - 1], mins[i - 2]) + cost[i];
        }
        return Math.min(mins[length - 1], mins[length - 2]);
    }
}
