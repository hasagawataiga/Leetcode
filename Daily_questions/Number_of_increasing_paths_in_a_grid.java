public class Number_of_increasing_paths_in_a_grid {
    int mod = 1_000_000_007;
    int count = 0;
    public int countPaths(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                count += dfs(grid, dp, grid[i][j] - 1, i, j, row, col);
                count %= mod;
            }
        }
        return count % mod;        
    }
    private int dfs(int[][] grid, int[][] dp, int val, int i, int j, int row, int col){
        if (i < 0 || j < 0 || i == row || j == col || grid[i][j] <= val){
            return 0;
        }
        if (dp[i][j] != 0){
            return dp[i][j];
        }
        // visited[i][j] = true;
        int num = 1;
        num += dfs(grid, dp, grid[i][j], i, j + 1, row, col);
        num %= mod;
        num += dfs(grid, dp, grid[i][j], i, j - 1, row, col);
        num %= mod;
        num += dfs(grid, dp, grid[i][j], i + 1, j, row, col);
        num %= mod;
        num += dfs(grid, dp, grid[i][j], i - 1, j, row, col);
        num %= mod;
        dp[i][j] = num % mod;
        return dp[i][j];
    }
}
