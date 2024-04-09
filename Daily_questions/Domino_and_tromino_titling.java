public class Domino_and_tromino_titling {
    int MOD = 1_000_000_007;
    public int numTilings(int n) {
        int[][] dp = new int[n][3];
        traversal(n - 1, dp);
        return dp[n - 1][0];
    }
    private void traversal(int index, int[][] dp) {
        if (index == 0) {
            dp[index][0] = 1;
            return;
        }
        if (index == 1) {
            dp[index][0] = 2;
            dp[index][1] = 1;
            dp[index][2] = 1;
            return;
        }
        if (dp[index][0] != 0) {
            return;
        }
        traversal(index - 1, dp);
        traversal(index - 2, dp);
        dp[index][0] = ((dp[index - 1][0] + dp[index - 1][1]) % MOD + (dp[index - 1][2] + dp[index - 2][0]) % MOD) % MOD;
        dp[index][1] = (dp[index - 1][2] + dp[index - 2][0]) % MOD;
        dp[index][2] = (dp[index - 1][1] + dp[index - 2][0]) % MOD;
        return;
    }
}
