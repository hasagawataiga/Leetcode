package interview_questions.dynamic_programming;

public class Climbing_stairs {
    public int climbStairs(int n) {
        if (n == 1) {return 1;}
        int[] dp = new int[n];
        // There is only 1 way to climb to stair 1st (0 -> 1)
        dp[0] = 1;
        // There are two ways to climb to stair 2nd (0 --> 2 && 0 -- > 1, 1 --> 2);
        dp[1] = 2;
        for (int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}