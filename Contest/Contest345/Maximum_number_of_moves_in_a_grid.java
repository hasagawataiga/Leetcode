package Contest.Contest345;


// DFS approach
public class Maximum_number_of_moves_in_a_grid {
    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        int max = 0;
        for (int i = 0; i < row; i++){
            max = Math.max(max, dfs(grid, dp, i, 0, visited, row, col));
        }
        return max > 0 ? max - 1 : 0;
    }
    private int dfs(int[][] grid, int[][] dp, int i, int j, boolean[][] visited, int row, int col){
        if (i < 0 || i >= row || j >= col || visited[i][j]){
            return 0;
        }
        if (dp[i][j] != 0){
            return dp[i][j];
        }
        visited[i][j] = true;
        int option1 = 0;
        int option2 = 0;
        int option3 = 0;
        if (j < col - 1){
            if (i < row - 1 && grid[i][j] < grid[i + 1][j + 1]){
                option1 = dfs(grid, dp, i + 1, j + 1, visited, row, col);
            }
            if (i > 0 && grid[i][j] < grid[i - 1][j + 1]){
                option2 = dfs(grid, dp, i - 1, j + 1, visited, row, col);
            }
            if (grid[i][j] < grid[i][j + 1]){
                option3 = dfs(grid, dp, i, j + 1, visited, row, col);                
            }
        }
        
        int max = Math.max(option1, Math.max(option2, option3));
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}
