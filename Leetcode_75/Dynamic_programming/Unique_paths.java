package Leetcode_75.Dynamic_programming;

public class Unique_paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
    }
    private void moves(int[][] dp, int m, int n){
        if ((m == dp.length - 1) && (n == dp[m].length - 1)){
            return;
        }
        if (m == dp.length - 1){
            dp[m][n] = dp[m][n - 1];
            return;
        }
        if (n == 0){
            dp[m][n] = dp[m - 1][n];
        }

    }
}
