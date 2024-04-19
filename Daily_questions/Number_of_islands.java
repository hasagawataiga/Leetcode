public class Number_of_islands {
    int rows;
    int cols;
    boolean[][] isChecked;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        isChecked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!isChecked[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || isChecked[i][j]) {
            return;
        }
        isChecked[i][j] = true;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
