package Leetcode_75.Graph_DFS_BFS;

public class Number_of_islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, int m, int n) {
        grid[row][col] = '0';
        if (row < m - 1 && grid[row + 1][col] == '1'){
            dfs(grid, row + 1, col, m, n);
        }
        if (row > 0 && grid[row - 1][col] == '1'){
            dfs(grid, row - 1, col, m, n);
        }
        if (col < n - 1 && grid[row][col + 1] == '1'){
            dfs(grid, row, col + 1, m, n);
        }
        if (col > 0 && grid[row][col - 1] == '1'){
            dfs(grid, row, col - 1, m, n);
        }
    }
}
