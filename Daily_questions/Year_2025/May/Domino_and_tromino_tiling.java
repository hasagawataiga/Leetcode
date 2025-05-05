public class Domino_and_tromino_tiling {
    class Solution {
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
}
