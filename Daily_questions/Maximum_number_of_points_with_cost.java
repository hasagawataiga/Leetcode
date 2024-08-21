public class Maximum_number_of_points_with_cost {
    class Solution {
        int rows;
        int cols;
        long[][] dp;
        public long maxPoints(int[][] points) {
            rows = points.length;
            cols = points[0].length;
            dp = new long[rows][cols];
            for (int i = 0; i < cols; i++) {
                dp[0][i] = points[0][i];
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 0;  j < cols; j++) {
                    dp[i][j] = points[i][j] + findMax(points, i, j, dp);
                }
            }
            long res = 0;
            for (int i = 0; i < cols; i++) {
                res = Math.max(res, dp[rows - 1][i]);
            }
            return res;
        }
    
        private long findMax(int[][] points, int i, int j, long[][] dp) {
            long val = dp[i - 1][j];
            for (int k = 0; k < cols; k++) {
                long currentVal = dp[i - 1][k] - Math.abs(k - j);
                val = Math.max(val, currentVal);
            }
            return val;
        }
    }
}
