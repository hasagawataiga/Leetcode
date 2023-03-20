package Dynamic_programming_plan.Dynamic_programming_I;

public class Min_cost_climbing_stairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] mins = new int[cost.length + 1];
        mins[0] = 0;
        mins[1] = cost[0];
        for (int i = 2; i < mins.length; i++){
            mins[i] = Math.min(mins[i - 1], mins[i - 2]) + cost[i - 1];
        }
        return Math.min(mins[mins.length - 1], mins[mins.length - 2]);
    }
}
