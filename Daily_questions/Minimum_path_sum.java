

public class Minimum_path_sum{
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = grid[i][j] + findMin(dp, grid, i, j);
            }
        }
        return dp[m - 1][n - 1];
    }
    private int findMin(int[][] dp, int[][] grid, int row, int col){
        int min = 0;
        if (row == 0 && col == 0){
            return 0;
        }
        if (row == 0){
            min = dp[row][col - 1];
        } else if (col == 0){
            min = dp[row - 1][col];
        } else {
            min = Math.min(dp[row][col - 1], dp[row - 1][col]);
        }
        return min;
    }
}