public class Shortest_path_in_binary_matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        boolean[][] reachEnd = new boolean[row][col];
        int[][] dp = new  int[row][col];
        int min = -1;
        if (dfs(grid, dp, visited, reachEnd, 0, 0, row, col)){
            min = dp[0][0];
        }
        return min;
    }
    private boolean dfs(int[][] grid, int[][] dp, boolean[][] visited, boolean[][] reachEnd, int i, int j, int row, int col){
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 1){
            return false;
        }
        if (i == row - 1 && j == col - 1){
            dp[i][j] = 1;
            return true;
        }
        if (visited[i][j]){
            if (reachEnd[i][j]){
                return true;
            } else {
                return false;
            }
        }
        visited[i][j] = true;
        int min = Integer.MAX_VALUE;
        if (dfs(grid, dp, visited, reachEnd, i, j + 1, row, col)){
            min = Math.min(min, dp[i][j + 1]);
        }
        // if (dfs(grid, dp, visited, reachEnd, i, j - 1, row, col)){
        //     min = Math.min(min, dp[i][j - 1]);
        // }
        if (dfs(grid, dp, visited, reachEnd, i + 1, j, row, col)){
            min = Math.min(min, dp[i + 1][j]);
        }
        // if (dfs(grid, dp, visited, reachEnd, i - 1, j, row, col)){
        //     min = Math.min(min, dp[i - 1][j]);
        // }
        if (dfs(grid, dp, visited, reachEnd, i + 1, j + 1, row, col)){
            min = Math.min(min, dp[i + 1][j + 1]);
        }
        // if (dfs(grid, dp, visited, reachEnd, i + 1, j - 1, row, col)){
        //     min = Math.min(min, dp[i + 1][i - 1]);
        // }
        // if (dfs(grid, dp, visited, reachEnd, i - 1, j + 1, row, col)){
        //     min = Math.min(min, dp[i - 1][j + 1]);
        // }
        // if (dfs(grid, dp, visited, reachEnd, i - 1, j - 1, row, col)){
        //     min = Math.min(min, dp[i - 1][j - 1]);
        // }
        if (min != Integer.MAX_VALUE){
            dp[i][j] = min + 1;
            return true;
        } else {
            return false;
        }
    }
}
