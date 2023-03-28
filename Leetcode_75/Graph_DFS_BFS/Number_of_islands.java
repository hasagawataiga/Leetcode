package Leetcode_75.Graph_DFS_BFS;

public class Number_of_islands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, boolean[][] visited, int row, int col){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }
        if (visited[row][col]){
            return;
        }
        if (grid[row][col] == 0){
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row, col - 1);
        dfs(grid, visited, row, col + 1);
    }
}
