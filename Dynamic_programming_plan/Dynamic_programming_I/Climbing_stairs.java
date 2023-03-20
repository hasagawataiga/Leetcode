package Dynamic_programming_plan.Dynamic_programming_I;

public class Climbing_stairs {
    int[] maxs = new int[46];
    public int climbStairs(int n) {
        // Base case
        if (n == 1 || n == 2){
            maxs[n] = n;
            return maxs[n];
        }
        // Recursion
        if (maxs[n - 1] == 0){
            maxs[n - 1] = climbStairs(n - 1);
        }
        if (maxs[n - 2] == 0){
            maxs[n - 2] = climbStairs(n - 2);
        }
        maxs[n] = maxs[n - 1] + maxs[n - 2];
        return maxs[n];
    }
}
