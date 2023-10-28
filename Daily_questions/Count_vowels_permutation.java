public class Count_vowels_permutation {
    long MOD = 1_000_000_007;
    public int countVowelPermutation(int n) {
        long dp[][] = new long[n][5];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;
        traverse(n, dp, 1);
        return (int)((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3] + dp[n - 1][4]) % MOD);
    }
    private void traverse(int n, long[][] dp, int index){
        if (index == n){
            return;
        }
        dp[index][0] = (dp[index - 1][1]) % MOD;
        dp[index][1] = (dp[index - 1][0] + dp[index - 1][2]) % MOD;
        dp[index][2] = (dp[index - 1][0] + dp[index - 1][1] + dp[index - 1][3] + dp[index - 1][4]) % MOD;
        dp[index][3] = (dp[index - 1][2] + dp[index - 1][4]) % MOD;
        dp[index][4] = dp[index - 1][0] % MOD;
        traverse(n, dp, index + 1);
    }
}
