package Algorithm_plan.BFS_DFS;

public class Max_area_of_island {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int max = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (!visited[i][j]){
                    int[] area = new int[1];
                    dfs(grid, row, col, i, j, visited, area);
                    max = Math.max(max, area[0]);
                }
            }
        }
        return max;
    }
    private void dfs(int[][] grid, int row, int col, int i, int j, boolean[][] visited, int[] area){
        if (i < 0 || j < 0 || i > row - 1 || j > col - 1){
            return;
        }
        if (visited[i][j]){
            return;
        }
        if (grid[i][j] == 0){
            return;
        }
        visited[i][j] = true;
        area[0]++;
        dfs(grid, row, col, i, j + 1, visited, area);
        dfs(grid, row, col, i, j - 1, visited, area);
        dfs(grid, row, col, i + 1, j, visited, area);
        dfs(grid, row, col, i - 1, j, visited, area);
    }
}
