public class Domino_and_tromino_titling {
    int MOD = 1_000_000_007;
    public int numTilings(int n) {
        int[] dp = new int[n];
        traversal(n - 1, dp);
        return dp[n - 1];
    }
    private void traversal(int index, int[] dp) {
        if (index == 0) {
            dp[index] = 1;
            return;
        }
        if (index == 1) {
            dp[index] = 2;
            return;
        }
        if (index == 2) {
            dp[index] = 5;
            return;
        }
        if (dp[index] != 0) {
            return;
        }
        traversal(index - 1, dp);
        traversal(index - 3, dp);
        dp[index] = (2 * dp[index - 1] % MOD + dp[index -  3]) % MOD;
        return;
    }
}

// Second Approac
// For this problem:
// dp[n] = dp[n-1] + dp[n-2] + 2 * (dp[n-3] + ... + dp[0]) -- E1
// dp[n-1] = dp[n-2] + dp[n-3] + 2 * (dp[n-4] + ... + dp[0]) -- E2
// E1 - E2:
// dp[n] - dp[n-1] = dp[n-1] + dp[n-3]
// --> dp[n] = 2*dp[n-1] + dp[n-3]
