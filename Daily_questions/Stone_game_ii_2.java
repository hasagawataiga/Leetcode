public class Stone_game_ii_2 {
    class Solution {
        int[][] alices;
        int[][] bobs;
        public int stoneGameII(int[] piles) {
            int length = piles.length;
            int[][] alices = new int[length][2];
            int[][] bobs = new int[length][2];
            return 0;
        }
    
        private int pickPiles(int[] piles, int index, int m, Player player) {
            if (dp[index][m] != 0) {
                return dp[index][m];
            }
            if (index == piles.length - 1) {
                dp[index][m] = piles[index];
                return dp[index][m];
            }
            int max = 0;
            for (int i = 0; i < m * 2; i++) {
                max = Math.max(max, pickPiles(dp, piles, index, Math.max(i, m)));
            }
            // Alice
            for (int i = 0; i < m * 2; i++) {
                max = Math.max(max, pickPiles(dp, piles, index, Math.max(i, m)));
            }
            dp[index][m] = max;
            return d[[index][m];
        }
    }
    
    enum Player {
        APLICE,
        BOB
    }
}
