



// From Leetcode Editorial
public class Stone_game_II {

    public static void main(String[] args) {
        int[] example = new int[]{2, 7, 9, 4, 4};
        Stone_game_II instance = new Stone_game_II();
        System.out.println(instance.stoneGameII(example));
    }

    private int f(int[] piles, int[][][] dp, int p, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        if (dp[p][i][m] != -1) {
            return dp[p][i][m];
        }
        int res = p == 1 ? 1000000 : -1, s = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = Math.max(res, s + f(piles, dp, 1, i + x, Math.max(m, x)));
            }
            else {
                res = Math.min(res, f(piles, dp, 0, i + x, Math.max(m, x)));
            }
        }
        return dp[p][i][m] = res;
    }
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length + 1][piles.length + 1];
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i <= piles.length; i++) {
                for (int m = 0; m <= piles.length; m++) {
                    dp[p][i][m] = -1;
                }
            }
        }
        return f(piles, dp, 0, 0, 1);
    }
}


